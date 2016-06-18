package controllers;

import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import services.UserService;
import views.html.login;

import java.util.Map;

/**
 * Created by RENT on 2016-06-15.
 */
public class LoginAndLogoutController extends Controller {


    public Result loginForm() {
        return ok(login.render());
    }

    public Result login() {
        UserService userService = new UserService();

        Map<String, String[]> data = request().body().asFormUrlEncoded();
        String password = data.get("password")[0];
        String username = data.get("name")[0];

        User user = userService.findByUsernameAndPassword(username, password);

        if (user != null) {
            session("userId", String.valueOf(user.getId()));
            session("userRole", user.getAccountRole());
            session("username", user.getFirstName() + " " + user.getLastName());

            return redirect(routes.HomepageController.homepage());
        } else {
            return redirect(routes.LoginAndLogoutController.loginForm());
        }
    }

    public Result logout() {
        session().remove("userId");
        return redirect(routes.LoginAndLogoutController.loginForm());
    }
}
