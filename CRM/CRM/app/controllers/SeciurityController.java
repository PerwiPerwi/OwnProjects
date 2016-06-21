package controllers;

import models.User;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import services.UserService;

import javax.inject.Singleton;

@Singleton
public class SeciurityController extends Security.Authenticator {


    @Override
    public Result onUnauthorized(Http.Context ctx) {
        if (getUser() == null) {
            return redirect(routes.LoginAndLogoutController.loginForm());
        }

        return super.onUnauthorized(ctx);
    }

    @Override
    public String getUsername(Http.Context ctx) {
        UserService userService = new UserService();
        if (ctx.session().get("userId") == null) {
            return null;
        }
        User user = userService.findById(Long.valueOf(ctx.session().get("userId")));
        if (user != null) {
            ctx.args.put("user", user);
            return user.getName();
        }
        return null;
    }

    public static User getUser() {
        return (User) Http.Context.current().args.get("user");
    }

    public static String getRole() {
        User user = getUser();
        String userRole = user.getAccountRole();
        return userRole;
    }

}
