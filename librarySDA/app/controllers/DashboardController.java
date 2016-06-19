package controllers;

import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import services.UserService;
import views.html.dashboard.adminPanel;

import java.util.List;

/**
 * Created by RENT on 2016-06-15.
 */
public class DashboardController extends Controller {


    public Result adminPanel (){
        UserService userService = new UserService();
        if(session("userId") == null || !session("userRole").equals("ADMIN")){
            return redirect(routes.Application.index());
        }

        List<User> users = userService.getAllUsers();
        return ok(adminPanel.render(users));
    }

}
