package dao;

import models.Book;

import java.util.List;

/**
 * Created by RENT on 2016-06-11.
 */
public interface BookDAO extends GenericDAO<Book, Long> {
    Book getBookByISBN(String isbn);

    List<Book> getAll();
    List<Book> getAllAvailableBooks();
    void changeBookStatus(long bookId, String status);
}
