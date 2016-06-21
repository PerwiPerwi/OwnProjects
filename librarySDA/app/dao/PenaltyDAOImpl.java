package dao;

import com.avaje.ebean.Ebean;
import models.Penalty;
import models.Rental;
import models.User;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.util.List;

/**
 * Created by RENT on 2016-06-11.
 */
public class PenaltyDAOImpl implements PenaltyDAO {
    @Override
    public void create(Penalty newObject) {
    }

    @Override
    public void update(Penalty object) {
    }

    @Override
    public boolean delete(Long primaryKey) {
        return false;
    }

    @Override
    public Penalty getById(Long penaltyId) {
        return Ebean.find(Penalty.class).where().eq("id", penaltyId).findUnique();
    }

    @Override
    public Penalty getByUserId(Long primaryKey) {
        return null;
    }

    @Override
    public List<Penalty> getAll() {
        return null;
    }

    @Override
    public Penalty createPenalty(User user, Rental rental) {
        int days = Days.daysBetween(new DateTime(),rental.getReturnDate()).getDays();
        double ammount = days * 0.5;
        Penalty penalty = new Penalty();
        penalty.setRental(rental);
        penalty.setUser(user);
        penalty.setAmmount(ammount);
        Ebean.insert(penalty);
        return penalty;
    }

    @Override
    public List<Penalty> getAllNotPayedPenaltyByUserId(long userId) {
        return Ebean.find(Penalty.class).where().eq("user_id", userId).eq("penalty_status","NOT_PAYED").findList();
    }

    @Override
    public List<Penalty> getAllPayedPenaltyByUserId(long userId) {
        return Ebean.find(Penalty.class).where().eq("user_id", userId).eq("penalty_status","PAYED").findList();
    }

    @Override
    public void payPenalty(long penaltyId) {
        Penalty penalty = getById(penaltyId);
        penalty.setPenaltyStatus("PAYED");
        Ebean.update(penalty);
    }
}
