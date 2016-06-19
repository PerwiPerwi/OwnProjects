package dao;

import models.Book;
import models.Rental;
import models.User;

import java.util.List;


/**
 * Created by RENT on 2016-06-11.
 */
public interface RentalDAO extends GenericDAO<Rental, Long> {
    Rental rentBook(User user, Book book);
    Rental getRentalByUserIdAndBookID(long userId, long bookId);
    List<Rental> getAllRentalsByUserId(long userId);
}
