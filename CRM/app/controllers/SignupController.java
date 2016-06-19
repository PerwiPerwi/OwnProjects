package controllers;

import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.UserService;
import views.html.errors.errors;
import views.html.signup;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class SignupController extends Controller {

    @Inject
    FormFactory formFactory;

    public Result signupForm() {
        if (session().get("userId") != null) {
            return redirect(routes.HomepageController.homepage());
        }
        Form<User> userForm = formFactory.form(User.class);
        return ok(signup.render(userForm, null));
    }

    public Result signupController() {
        UserService userService = new UserService();
        Form<User> userForm = formFactory.form(User.class).bindFromRequest();
        if (userForm.hasErrors()) {
            return badRequest(signup.render(userForm, "Check Your Form"));
        }
        String password = userForm.get().getPassword();
        Map<String, String[]> data = request().body().asFormUrlEncoded();
        String confirmPassword = data.get("confirmPassword")[0];
        if (userForm.hasErrors() && !password.equals(confirmPassword)) {
            return badRequest(signup.render(userForm, "Password and Confirm Password Did Not Match"));
        } else if (userForm.hasErrors()) {
            return badRequest(signup.render(userForm, null));
        } else if (!password.equals(confirmPassword)) {
            return badRequest(signup.render(userForm, "Password and Confirm Password Did Not Match"));
        }

        User user = userForm.get();
        List<String> errorList = userService.checkIfDataExist(null, user.getName(), user.getEmail());
        if (!errorList.isEmpty()) {
            return ok(errors.render(errorList));
        }
        userService.create(user);
        return redirect(routes.LoginAndLogoutController.loginForm());
    }

}
