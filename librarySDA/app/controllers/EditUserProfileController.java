package controllers;

import com.avaje.ebean.Ebean;
import dao.UserDAOImpl;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import services.UserService;
import views.html.editUserEmail;
import views.html.editUserPassword;
import views.html.editUserProfile;
import views.html.errors.errors;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

import static jdk.nashorn.internal.objects.NativeString.valueOf;

/**
 * Created by RENT on 2016-06-15.
 */
public class EditUserProfileController extends Controller {

    @Inject
    FormFactory formFactory;
    UserService userService = new UserService();

    @Security.Authenticated(SeciurityController.class)
    public Result editUserProfileForm() {
        if (session("userId") == null) {
            return redirect(routes.Application.index());
        }
        User user = SeciurityController.getUser();
        Form<User> userForm = formFactory.form(User.class).fill(user);
        return ok(editUserProfile.render(userForm));
    }

    @Security.Authenticated(SeciurityController.class)
    public Result editUserProfile() {
        Form<User> userForm = formFactory.form(User.class).bindFromRequest();
        User userFromForm = userForm.get();
        User user = SeciurityController.getUser();
        userService.updateFirstNameAndLastName(user, userFromForm);
        return redirect(routes.EditUserProfileController.editUserProfileForm());
    }

    @Security.Authenticated(SeciurityController.class)
    public Result editUserPasswordForm() {
        User user = SeciurityController.getUser();
        return ok(editUserPassword.render(user, null));
    }

    @Security.Authenticated(SeciurityController.class)
    public Result editUserPassword() {
        User user = SeciurityController.getUser();
        Map<String, String[]> data = request().body().asFormUrlEncoded();
        String actualPassword = user.getPassword();
        String password = data.get("password")[0];
        String confirmPassword = data.get("passwordConfirm")[0];

        if (!password.equals(confirmPassword)) {
            return ok(editUserPassword.render(user, "Password and Confirm Password, Did Not Match!"));
        } else if (password.length() < 5 || password.length() > 15) {
            return ok(editUserPassword.render(user, "Wrong Password Size, Must Be Longer than 3 Characters and Shorter than 15"));
        } else if (actualPassword.equals(password)) {
            return ok(editUserPassword.render(user, "Old Password and New Password Are They Same!"));
        }
        userService.updateUserPassword(user, password);
        return redirect(routes.EditUserProfileController.editUserProfileForm());
    }

    @Security.Authenticated(SeciurityController.class)
    public Result editUserEmailForm() {
        User user = SeciurityController.getUser();
        Form<User> userForm = formFactory.form(User.class).fill(user);
        return ok(editUserEmail.render(userForm, null));
    }

    @Security.Authenticated(SeciurityController.class)
    public Result editUserEmail() {
        User user = SeciurityController.getUser();
        Form<User> userForm = formFactory.form(User.class).bindFromRequest();
        if (userForm.hasErrors()) {
            return badRequest(editUserEmail.render(userForm, null));
        }
        User userFromForm = userForm.get();
        userService.updateUserEmail(user, userFromForm);
        //userService.updateUserEmail(user, email);
        return redirect(routes.EditUserProfileController.editUserProfileForm());
    }

}
