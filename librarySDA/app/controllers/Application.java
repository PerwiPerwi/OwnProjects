package controllers;

        import play.mvc.Controller;
        import play.mvc.Result;

/**
 * Created by RENT on 2016-06-11.
 */
public class Application extends Controller {

    public Result index() {
        return ok(views.html.index.render());
    }

}
