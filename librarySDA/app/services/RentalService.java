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
    public List<Rental> getAllReturnedUserRentalsByUserId(long userId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        RentalDAO rentalDAO = factory.getRentalDAO();
        return rentalDAO.getAllReturnedRentals(userId);
    }
    public List<Rental> getAllNotReturnedUserRentalsByUserId(long userId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        RentalDAO rentalDAO = factory.getRentalDAO();
        return rentalDAO.getAllNotReturnedRentals(userId);
    }
    public Rental getRentalById(long rentalId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        RentalDAO rentalDAO = factory.getRentalDAO();
        return rentalDAO.getById(rentalId);
    }
    public void returnRental(Rental rental, Book book) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        RentalDAO rentalDAO = factory.getRentalDAO();
        rentalDAO.returnRental(rental, book);
    }
}
