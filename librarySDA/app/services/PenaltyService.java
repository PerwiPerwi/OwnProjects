package services;

import dao.DAOFactory;
import dao.PenaltyDAO;
import models.Penalty;
import models.Rental;
import models.User;

import java.util.List;

/**
 * Created by RENT on 2016-06-11.
 */
public class PenaltyService {
    public Penalty createPenalty(User user, Rental rental) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        PenaltyDAO penaltyDAO = factory.getPenaltyDAO();
        return penaltyDAO.createPenalty(user, rental);
    }

    public Penalty getById(Long penaltyId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        PenaltyDAO penaltyDAO = factory.getPenaltyDAO();
        return penaltyDAO.getById(penaltyId);
    }

    public List<Penalty> getAllNotPayedPenaltyByUserId(long userId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        PenaltyDAO penaltyDAO = factory.getPenaltyDAO();
        return penaltyDAO.getAllNotPayedPenaltyByUserId(userId);
    }

    public List<Penalty> getAllPayedPenaltyByUserId(long userId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        PenaltyDAO penaltyDAO = factory.getPenaltyDAO();
        return penaltyDAO.getAllPayedPenaltyByUserId(userId);
    }
    public void payPenalty(long penaltyId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        PenaltyDAO penaltyDAO = factory.getPenaltyDAO();
        penaltyDAO.payPenalty(penaltyId);
    }
}
