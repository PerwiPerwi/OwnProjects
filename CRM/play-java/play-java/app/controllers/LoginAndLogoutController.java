package controllers;

import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import services.UserService;
import views.html.login;

import java.util.Map;

public class LoginAndLogoutController extends Controller {


    public Result loginForm() {
        if (session().get("userId") != null) {
            return redirect(routes.HomepageController.homepage());
        }
        return ok(login.render(null));
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
            return ok(login.render("Wrong Name or Password"));
        }
    }

    public Result logout() {
        session().remove("userId");
        return redirect(routes.LoginAndLogoutController.loginForm());
    }
}
