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
import java.util.Map;

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
        if (!"ADMIN".equals(user.getAccountRole())) {
            return redirect(routes.HomepageController.homepage());
        }

        List<User> users = userService.getAllUsers();
        return ok(adminPanel.render(users));
    }

    @Security.Authenticated(SeciurityController.class)
    public Result editUserByAdminForm(long userId) {
        User userForCheck = SeciurityController.getUser();
        if (userForCheck == null) {
            return redirect(routes.LoginAndLogoutController.loginForm());
        }
        if (!"ADMIN".equals(userForCheck.getAccountRole())) {
            return redirect(routes.HomepageController.homepage());
        }
        User user = userService.findById(userId);
        Form<User> userForm = formFactory.form(User.class).fill(user);
        return ok(editUserByAdmin.render(userForm, null));
    }

    @Security.Authenticated(SeciurityController.class)
    public Result editUserByAdmin() {
        User user = SeciurityController.getUser();
        if (user == null) {
            return redirect(routes.LoginAndLogoutController.loginForm());
        }
        if (!"ADMIN".equals(user.getAccountRole())) {
            return redirect(routes.HomepageController.homepage());
        }

        Form<User> userForm = formFactory.form(User.class).bindFromRequest();
        if (userForm.hasErrors()) {
            return redirect(routes.AdminPanelController.adminPanel());
        }
        User userFromForm = userForm.get();
        User userForUpdate = userService.findById(userFromForm.getId());
        if(userService.getUserByEmail(userFromForm.getEmail())!= null && !userForUpdate.getEmail().equals(userFromForm.getEmail())){
            return ok(editUserByAdmin.render(userForm, "This Email is Already Registered"));
        }
        userService.updateUserByAdmin(userForUpdate, userFromForm);
        return redirect(routes.AdminPanelController.editUserByAdminForm(userForUpdate.getId()));
    }
    @Security.Authenticated(SeciurityController.class)
    public Result deleteUserByAdmin(long userId) {
        if (userService.delete(userId)) {
            return redirect(routes.AdminPanelController.adminPanel());
        }
        return badRequest();
    }
}
