package controllers;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import services.UserService;
import views.html.adminPanel;
import models.User;
import views.html.editUserByAdmin;
import views.html.errors.errors;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by RENT on 2016-06-16.
 */
public class AdminPanelController extends Controller {
    @Inject
    FormFactory formFactory;

    UserService userService = new UserService();

    @Security.Authenticated(SeciurityController.class)
    public Result adminPanel() {
        if (session("userId") == null || !"ADMIN".equals(session("userRole"))) {
            return redirect(routes.Application.index());
        }
        return ok(adminPanel.render(userService.getAllUsers()));
    }

    public Result editUserByAdminForm(long userId) {
        User user = userService.getByUserId(userId);
        Form<User> userForm = formFactory.form(User.class).fill(user);
        return ok(editUserByAdmin.render(userForm, null));
    }

    @Security.Authenticated(SeciurityController.class)
    public Result editUserByAdmin() {
        if (session("userId") == null || !"ADMIN".equals(session("userRole"))) {
            return redirect(routes.Application.index());
        }
        Form<User> userForm = formFactory.form(User.class).bindFromRequest();

        User userFromForm = userForm.get();
        User user = userService.getByUserId(userFromForm.getId());
        if(userService.getUserByEmail(userFromForm.getEmail()) == null && userFromForm.getEmail().equals(user.getEmail())){
            userService.updateUserByAdmin(user, userFromForm);
            return ok(editUserByAdmin.render(userForm, "User Profile has been updated!"));
        }
        return ok(editUserByAdmin.render(userForm, "This email is already registered!"));

    }


    public Result deleteUserByAdmin(long userId) {
        User user = userService.getByUserId(userId);
        if (user.delete()) {
            return redirect(routes.AdminPanelController.adminPanel());
        }
        return badRequest();
    }

}
