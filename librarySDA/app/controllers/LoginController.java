package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import dao.UserDAO;
import dao.UserDAOImpl;
import models.User;
import services.UserService;
import views.html.formLogin;

import java.util.Map;

/**
 * Created by RENT on 2016-06-14.
 */
public class LoginController extends Controller {

    public Result loginForm() {
        return ok(formLogin.render());
    }

    public Result login() {
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

        return redirect(routes.LoginController.loginForm());
    }

}
