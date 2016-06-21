package dao;

import models.Penalty;
import models.Rental;
import models.User;

import java.util.List;

/**
 * Created by RENT on 2016-06-11.
 */
public interface PenaltyDAO extends GenericDAO<Penalty, Long> {
    Penalty createPenalty(User user, Rental rental);
    List<Penalty> getAllNotPayedPenaltyByUserId(long userId);
    List<Penalty> getAllPayedPenaltyByUserId(long userId);
    void payPenalty(long penaltyId);
}
