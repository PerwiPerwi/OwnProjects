package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.homepage;

public class HomepageController extends Controller {

    @Security.Authenticated(SeciurityController.class)
    public Result homepage() {
        if (SeciurityController.getUser() == null) {
            return redirect(routes.LoginAndLogoutController.loginForm());
        }
        return ok(homepage.render());
    }
}
