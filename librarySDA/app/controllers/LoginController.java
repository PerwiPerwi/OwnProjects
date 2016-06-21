package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import models.User;
import services.UserService;
import views.html.formLogin;

import java.util.Map;

/**
 * Created by RENT on 2016-06-14.
 */
public class LoginController extends Controller {

    public Result loginForm() {
        if(session("userId") != null ){
            return redirect(routes.Application.index());
        }
        return ok(formLogin.render(null));
    }

    public Result login() {
        if(session("userId") != null ){
            return redirect(routes.Application.index());
        }
        UserService userService = new UserService();
        Map<String, String[]> data = request().body().asFormUrlEncoded();
        String email = data.get("email")[0];
        String password = data.get("password")[0];
        User user = userService.getUserByEmailAndPassword(email, password);
        if (user != null) {
            session("userId", String.valueOf(user.getId()));
            session("userRole", user.getAccountRole());
            session("username", user.getFirstName() + " " + user.getLastName());
            return redirect(routes.Application.index());
        }
        return ok (formLogin.render("Wrong Email or Password!"));
    }

}
