package services;

import dao.BookDAO;
import dao.DAOFactory;
import models.Book;

import java.util.List;

/**
 * Created by RENT on 2016-06-11.
 */
public class BookService {

    public List<Book> getAll() {
        DAOFactory factory = DAOFactory.getDAOFactory();
        BookDAO bookDAO = factory.getBookDAO();
        List<Book> books = bookDAO.getAll();
        return books;
    }
    public Book getBookById(long bookId){
        DAOFactory factory = DAOFactory.getDAOFactory();
        BookDAO bookDAO = factory.getBookDAO();
        return bookDAO.getById(bookId);
    }
    public List<Book> getAllAvailableBooks() {
        DAOFactory factory = DAOFactory.getDAOFactory();
        BookDAO bookDAO = factory.getBookDAO();
        return bookDAO.getAllAvailableBooks();
    }
    public void changeBookStatus(long bookId, String status) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        BookDAO bookDAO = factory.getBookDAO();
        bookDAO.changeBookStatus(bookId, status);

    }
}
