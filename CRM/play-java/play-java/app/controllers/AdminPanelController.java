package controllers;

import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import services.UserService;
import views.html.adminPanel;
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
        User user = SeciurityController.getUser();
        if (user == null) {
            return redirect(routes.LoginAndLogoutController.loginForm());
        }
        if (!user.getAccountRole().equals("ADMIN")) {
            return redirect(routes.HomepageController.homepage());
        }


        List<User> users = userService.getAllUsers();
        return ok(adminPanel.render(users));
    }

    @Security.Authenticated(SeciurityController.class)
    public Result editUserByAdminForm(long userId) {
        User user = userService.findById(userId);
        Form<User> userForm = formFactory.form(User.class).fill(user);
        return ok(editUserByAdmin.render(user, userForm));
    }

    @Security.Authenticated(SeciurityController.class)
    public Result editUserByAdmin() {
        Form<User> userForm = formFactory.form(User.class).bindFromRequest();
        User user = userForm.get();

        if (userForm.hasErrors()) {
            return badRequest(editUserByAdmin.render(user, userForm));
        }

        List<String> errorList = userService.checkIfDataExist(user.getName(), user.getEmail());

        if (!errorList.isEmpty()) {
            return ok(errors.render(errorList));
        }
        userService.update(user);
        return redirect(routes.AdminPanelController.adminPanel());
    }


    public Result deleteUserByAdmin(long userId) {
        User user = userService.findById(userId);
        if (user.delete()) {
            return redirect(routes.AdminPanelController.adminPanel());
        }
        return badRequest();
    }

    public Result deleteUserProfilePictureByAdmin(long userId) {
        User user = userService.findById(userId);
        user.setProfilPicture("defaultPicture.png");
        userService.update(user);
        return redirect(routes.AdminPanelController.editUserByAdminForm(userId));

    }
}
