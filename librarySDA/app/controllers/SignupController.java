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
import java.util.Map;

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
        if(session("userId") != null ){
            return redirect(routes.Application.index());
        }
        Form<User> userForm = formFactory.form(User.class);
        return ok(views.html.signup.signupForm.render(userForm, null));
    }

    public Result signupController() {
        if(session("userId") != null ){
            return redirect(routes.Application.index());
        }
        UserService userService = new UserService();
        Map<String, String[]> data = request().body().asFormUrlEncoded();
        String confirmPassword = data.get("confirmPassword")[0];
        Form<User> userForm = formFactory.form(User.class).bindFromRequest();
        if(userForm.hasErrors()){
            return badRequest(views.html.signup.signupForm.render(userForm, "Check You Signup Form!"));
        } else if(!userForm.get().getPassword().equals(confirmPassword) ){
            return badRequest(views.html.signup.signupForm.render(userForm, "Password and Confirm Password Did Not Match!"));
        }
        User user = userForm.get();
        List<String> errorList = userService.checkIfDataExist(null, user.getEmail());

        if (!errorList.isEmpty()) {
            return ok(errors.render(errorList));
        }
        userService.create(user);
        return redirect(routes.LoginController.loginForm());
    }


}
