package controllers;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by RENT on 2016-06-15.
 */
public class AboutController extends Controller {

    public Result about() {
        return ok(views.html.about.render());
    }

}
