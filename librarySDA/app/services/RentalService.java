package services;

import dao.DAOFactory;
import dao.RentalDAO;
import models.Book;
import models.Rental;
import models.User;

import java.util.List;

/**
 * Created by RENT on 2016-06-11.
 */
public class RentalService {
    public Rental rentBook(User user, Book book) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        RentalDAO rentalDAO = factory.getRentalDAO();
        return rentalDAO.rentBook(user, book);
    }
    public Rental getRentalByUserIdAndBookID(long userId, long bookId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        RentalDAO rentalDAO = factory.getRentalDAO();
        return rentalDAO.getRentalByUserIdAndBookID(userId, bookId);
    }
    public List<Rental> getAllRentalsByUserId(long userId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        RentalDAO rentalDAO = factory.getRentalDAO();
        return rentalDAO.getAllRentalsByUserId(userId);
    }
}
