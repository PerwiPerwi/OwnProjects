package controllers;

import models.Penalty;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import services.PenaltyService;
import views.html.dashboard.payedPenalty;
import views.html.dashboard.notPayedPenalty;

import java.util.List;

/**
 * Created by RENT on 2016-06-21.
 */
public class PenaltyController extends Controller {
    @Security.Authenticated(SeciurityController.class)
    public Result notPayedPenalty() {
        User user = SeciurityController.getUser();
        PenaltyService penaltyService = new PenaltyService();
        List<Penalty> penaltyList = penaltyService.getAllNotPayedPenaltyByUserId(user.getId());
        return ok(notPayedPenalty.render(penaltyList));
    }

    @Security.Authenticated(SeciurityController.class)
    public Result payedPenalty() {
        User user = SeciurityController.getUser();
        PenaltyService penaltyService = new PenaltyService();
        List<Penalty> penaltyList = penaltyService.getAllPayedPenaltyByUserId(user.getId());
        return ok(payedPenalty.render(penaltyList));
    }
    @Security.Authenticated(SeciurityController.class)
    public Result payPenaltyController(long penaltyId){
        PenaltyService penaltyService = new PenaltyService();
        penaltyService.payPenalty(penaltyId);
        return redirect(routes.PenaltyController.notPayedPenalty());
    }
}
