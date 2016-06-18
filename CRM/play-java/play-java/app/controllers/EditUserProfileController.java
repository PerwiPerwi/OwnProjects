package controllers;

import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import services.UserService;
import views.html.updateProfileByUser.updateUserEmail;
import views.html.updateProfileByUser.updateUserPassword;
import views.html.updateProfileByUser.updateUserProfile;

import javax.inject.Inject;
import java.util.Map;

public class EditUserProfileController extends Controller {

    @Inject
    FormFactory formFactory;

    UserService userService = new UserService();

    @Security.Authenticated(SeciurityController.class)
    public Result editUserProfileForm() {
        User user = SeciurityController.getUser();
        if (user == null) {
            return redirect(routes.LoginAndLogoutController.loginForm());
        }
        Form<User> userEditForm = formFactory.form(User.class).fill(user);
        return ok(updateUserProfile.render(user, userEditForm));
    }

    @Security.Authenticated(SeciurityController.class)
    public Result editUserProfile() {
        Map<String, String[]> data = request().body().asFormUrlEncoded();
        String firstName = data.get("firstName")[0];
        String lastName = data.get("lastName")[0];
        User user = SeciurityController.getUser();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.update();
        return redirect(routes.EditUserProfileController.editUserProfileForm());
    }

    @Security.Authenticated(SeciurityController.class)
    public Result updateUserEmailByUserForm() {
        User user = SeciurityController.getUser();
        Form<User> userForm = formFactory.form(User.class).fill(user);
        return ok(updateUserEmail.render(user, userForm, null));
    }

    @Security.Authenticated(SeciurityController.class)
    public Result updateUserEmailByUser() {
        Map<String, String[]> data = request().body().asFormUrlEncoded();
        String email = data.get("email")[0];
        User userForUpdate = SeciurityController.getUser();
        User userForCheck = userService.getUserByEmail(email);
        Form<User> userForm = formFactory.form(User.class).fill(userForUpdate);
        if (!userService.validateEmail(email)) {
            return ok(updateUserEmail.render(userForUpdate, userForm, "Wrong Email Format!"));
        } else if (userForCheck != null && userForCheck.getId() != userForUpdate.getId()) {
            return ok(updateUserEmail.render(userForUpdate, userForm, "Wrong Email Format!"));
        }
        userService.updateEmail(userForUpdate, email);
        return redirect(routes.EditUserProfileController.editUserProfileForm());
    }

    @Security.Authenticated(SeciurityController.class)
    public Result updateUserPasswordForm() {
        return ok(updateUserPassword.render(""));
    }

    @Security.Authenticated(SeciurityController.class)
    public Result updateUserPassword() {
        Map<String, String[]> data = request().body().asFormUrlEncoded();
        String actualPassword = SeciurityController.getUser().getPassword();
        String password = data.get("password")[0];
        String confirmPassword = data.get("confirmPassword")[0];

        if (!password.equals(confirmPassword)) {
            return ok(updateUserPassword.render("Password and Confirm Password, Did Not Match!"));
        } else if (password.length() < 5 || password.length() > 15) {
            return ok(updateUserPassword.render("Wrong Password Size, Must Be Longer than 3 Characters and Shorter than 15"));
        } else if (actualPassword.equals(password)) {
            return ok(updateUserPassword.render("Old Password and New Password Are They Same!"));
        }
        User userForUpdate = SeciurityController.getUser();
        userService.updatePassword(userForUpdate, password);
        return redirect(routes.EditUserProfileController.editUserProfileForm());
    }

    @Security.Authenticated(SeciurityController.class)
    public Result deleteUserAccountByUser(long userId) {
        if (userService.delete(userId)) {
            return redirect(routes.LoginAndLogoutController.logout());
        }
        return badRequest();
    }
}
