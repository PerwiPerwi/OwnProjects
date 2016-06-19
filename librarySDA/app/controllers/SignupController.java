package controllers;

import dao.UserDAOImpl;
import models.User;
import org.mindrot.jbcrypt.BCrypt;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.UserService;
import views.html.errors.errors;
import views.html.index;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by RENT on 2016-06-14.
 */
public class SignupController extends Controller {
    @Inject
    FormFactory formFactory;

    public Result signupFormController() {
        return ok(index.render());
    }

    public Result signupForm() {
        Form<User> userForm = formFactory.form(User.class);
        return ok(views.html.signup.signupForm.render(userForm));
    }

    public Result signupController() {
        UserService userService = new UserService();
        Form<User> userForm = formFactory.form(User.class).bindFromRequest();
        User user = userForm.get();
        List<String> errorList = userService.checkIfDataExist(null, user.getEmail());

        if (!errorList.isEmpty()) {
            return ok(errors.render(errorList));
        }
        userService.create(user);
        return redirect(routes.LoginController.loginForm());
    }


}
