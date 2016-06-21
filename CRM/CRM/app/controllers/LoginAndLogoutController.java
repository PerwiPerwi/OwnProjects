package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.json.JsonObject;
import models.User;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import services.UserService;
import views.html.login;
import views.html.loginByFacebook;

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

    public Result loginByFacebook() {
        return ok(loginByFacebook.render());
    }

    public Result authenticateUser(String accessToken) {
        UserService userService = new UserService();
        FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
        JsonObject jsonFacebookObject = facebookClient.fetchObject("me", JsonObject.class, Parameter.with("fields", "email,first_name,last_name"));
        String name = jsonFacebookObject.getString("first_name")+" "+jsonFacebookObject.getString("last_name");
        User user = userService.getUserByNameAndEmail(name, jsonFacebookObject.getString("email"));
        if (user != null) {
            session("userId", String.valueOf(user.getId()));
            session("userRole", user.getAccountRole());
            session("username", name);
            return redirect(routes.HomepageController.homepage());
        }
        User userCreatedByFacebook = new User();
        userCreatedByFacebook.setName(name);
        userCreatedByFacebook.setFirstName(jsonFacebookObject.getString("first_name"));
        userCreatedByFacebook.setLastName(jsonFacebookObject.getString("last_name"));
        userCreatedByFacebook.setEmail(jsonFacebookObject.getString("email"));
        userCreatedByFacebook.setPassword(jsonFacebookObject.getString("last_name"));
        userCreatedByFacebook.setCreatedBy("FACEBOOK");
        userCreatedByFacebook.insert();
        session("userId", String.valueOf(userCreatedByFacebook.getId()));
        session("userRole", userCreatedByFacebook.getAccountRole());
        session("username", name);
        return redirect(routes.HomepageController.homepage());
    }

    public Result logout() {
        session().remove("userId");
        return redirect(routes.LoginAndLogoutController.loginForm());
    }
}
