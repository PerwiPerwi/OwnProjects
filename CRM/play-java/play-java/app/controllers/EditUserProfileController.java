package controllers;

import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.db.ebean.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import services.UserService;
import views.html.editProfile.editUserProfile;
import views.html.errors.errors;


import javax.inject.Inject;
import java.util.List;

public class EditUserProfileController extends Controller {

    @Inject
    FormFactory formFactory;

    UserService userService = new UserService();

    @Security.Authenticated(SeciurityController.class)
    public Result editUserProfileForm() {
        if (SeciurityController.getUser() == null) {
            return redirect(routes.LoginAndLogoutController.loginForm());
        }
        User user = SeciurityController.getUser();
        Form<User> userEditForm = formFactory.form(User.class).fill(user);
        return ok(editUserProfile.render(user ,userEditForm));
    }
    @Transactional
    @Security.Authenticated(SeciurityController.class)
    public Result editUserProfile() {
        Form<User> userForm = formFactory.form(User.class).bindFromRequest();
        User user = userForm.get();

        List<String> errorList = userService.checkIfDataExist(user.getName(), user.getEmail());

        if (!errorList.isEmpty()) {
            return ok(errors.render(errorList));
        }
        userService.update(user);// <----------- by Ebean
        //user.update();            <----------- from Controller

        return redirect(routes.EditUserProfileController.editUserProfileForm());
    }

    @Security.Authenticated(SeciurityController.class)
    public Result deleteUserAccountByUser(long userId) {
        if(userService.delete(userId)){
            return redirect(routes.LoginAndLogoutController.logout());
        }
        return badRequest();
    }
}
