package dao;

import com.avaje.ebean.Ebean;
import models.Book;
import models.Rental;
import models.User;

import java.util.List;

/**
 * Created by RENT on 2016-06-11.
 */
public class RentalDAOImpl implements RentalDAO {
    @Override
    public void create(Rental newObject) {
    }

    @Override
    public void update(Rental object) {
    }

    @Override
    public boolean delete(Long primaryKey) {
        return false;
    }

    @Override
    public Rental getById(Long rentalId) {

        return Ebean.find(Rental.class).where().idEq(rentalId).findUnique();
    }

    @Override
    public Rental getByUserId(Long primaryKey) {
        return null;
    }

    @Override
    public List<Rental> getAll() {
        return null;
    }

    @Override
    public Rental rentBook(User user, Book book) {
        Rental rental = new Rental();
        rental.setUser(user);
        rental.setBook(book);
        book.setBookStatus("NOT_AVAILABLE");
        book.update();
        Ebean.insert(rental);
        return rental;
    }

    @Override
    public Rental getRentalByUserIdAndBookID(long userId, long bookId) {
        return Ebean.find(Rental.class).where().eq("user_id", userId).eq("book_id", bookId).findUnique();
    }

    @Override
    public List<Rental> getAllRentalsByUserId(long userId) {
        return Ebean.find(Rental.class).where().eq("user_id", userId).findList();
    }

    @Override
    public List<Rental> getAllNotReturnedRentals(long userId) {
        return Ebean.find(Rental.class).where().eq("user_id", userId).eq("rental_status","NOT RETURNED").findList();
    }

    @Override
    public List<Rental> getAllReturnedRentals(long userId) {
        return Ebean.find(Rental.class).where().eq("user_id", userId).eq("rental_status","RETURNED").findList();
    }

    @Override
    public void returnRental(Rental rental, Book book) {
        rental.setRentalStatus("RETURNED");
        Ebean.update(rental);
        book.setBookStatus("AVAILABLE");
        book.setRental(null);
        Ebean.update(book);
    }
}
