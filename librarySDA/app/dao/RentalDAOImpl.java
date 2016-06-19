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
    public Rental getById(Long primaryKey) {
        return null;
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
        Ebean.insert(rental);
        return rental;
    }

    @Override
    public Rental getRentalByUserIdAndBookID(long userId, long bookId) {
        return Ebean.find(Rental.class).where().eq("user_id", userId).eq("book_id",bookId).findUnique();
    }

    @Override
    public List<Rental> getAllRentalsByUserId(long userId) {
        return Ebean.find(Rental.class).where().eq("user_id", userId).findList();
    }
}
