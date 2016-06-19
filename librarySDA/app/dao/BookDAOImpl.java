package dao;

import com.avaje.ebean.Ebean;
import models.Book;

import java.util.List;

/**
 * Created by RENT on 2016-06-11.
 */
public class BookDAOImpl implements BookDAO {
    @Override
    public Book getBookByISBN(String isbn) {
        return null;
    }

    @Override
    public void create(Book newObject) {
    }

    @Override
    public void update(Book object) {
    }

    @Override
    public boolean delete(Long primaryKey) {
        return false;
    }

    @Override
    public Book getById(Long bookId) {
        return Ebean.find(Book.class).where().idEq(bookId).findUnique();
    }

    @Override
    public Book getByUserId(Long primaryKey) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return Ebean.find(Book.class).where()
                .orderBy("id asc")
                .findList();
    }

    @Override
    public List<Book> getAllAvailableBooks() {
        return Ebean.find(Book.class).where().eq("book_status", "AVAILABLE").orderBy("id asc")
                .findList();
    }

    @Override
    public void changeBookStatus(long bookId, String status) {
        Book book = getById(bookId);
        book.setBookStatus(status);
        Ebean.update(book);
    }
}
