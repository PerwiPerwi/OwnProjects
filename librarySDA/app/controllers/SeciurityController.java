package controllers;

import dao.UserDAOImpl;
import models.User;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import services.UserService;

import javax.inject.Singleton;

/**
 * Created by RENT on 2016-06-15.
 */
@Singleton
public class SeciurityController extends Security.Authenticator {
    @Override
    public Result onUnauthorized(Http.Context ctx) {
        return super.onUnauthorized(ctx);
    }

    public String getUsername(Http.Context ctx) {
        UserService userService = new UserService();
        if (ctx.session().get("userId") == null) {
            return null;
        }
        User user = userService.getByUserId(Long.valueOf(ctx.session().get("userId")));
        if (user != null) {
            ctx.args.put("user", user);
            return user.getFirstName()+" "+user.getLastName();
        }
        return null;
    }
    public static User getUser() {
        return (User) Http.Context.current().args.get("user");
    }
}