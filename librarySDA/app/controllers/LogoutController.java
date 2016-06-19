package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by RENT on 2016-06-15.
 */
public class LogoutController extends Controller {

    public Result logout() {
        session().remove("userId");
        return redirect(routes.Application.index());
    }
}
