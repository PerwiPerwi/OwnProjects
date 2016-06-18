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
        User user = userService.findById(userId);
        Form<User> userForm = formFactory.form(User.class).fill(user);
        return ok(editUserByAdmin.render(user, userForm, null));
    }

    @Security.Authenticated(SeciurityController.class)
    public Result editUserByAdmin() {
        Map<String, String[]> data = request().body().asFormUrlEncoded();
        long userId = Long.parseLong(data.get("id")[0]);
        String firstName = data.get("firstName")[0];
        String lastName = data.get("lastName")[0];
        String email = data.get("email")[0];
        String userRole = data.get("accountRole")[0];
        User userForUpdate = userService.findById(userId);
        User userForCheck = userService.getUserByEmail(email);
        Form<User> userForm = formFactory.form(User.class).fill(userForUpdate);
        if (!userService.validateEmail(email)) {
            return ok(editUserByAdmin.render(userForUpdate, userForm, "Wrong Email Format!"));
        } else if (userForCheck != null && userForCheck.getId() != userForUpdate.getId()) {
            return ok(editUserByAdmin.render(userForUpdate, userForm, "Email is Already Registered"));
        }
        userForUpdate.setFirstName(firstName);
        userForUpdate.setLastName(lastName);
        userService.updateUserRole(userForUpdate, userRole);
        userService.updateEmail(userForUpdate, email);
        return redirect(routes.AdminPanelController.adminPanel());
    }

    public Result deleteUserByAdmin(long userId) {
        User user = userService.findById(userId);
        if (user.delete()) {
            return redirect(routes.AdminPanelController.adminPanel());
        }
        return badRequest();
    }
}
