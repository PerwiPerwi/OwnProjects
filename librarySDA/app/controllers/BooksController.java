package controllers;

import models.Book;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.BookService;
import views.html.availableBookList;
import views.html.singleBookView;
import views.html.dashboard.books.all;
import views.html.dashboard.books.edit;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by RENT on 2016-06-15.
 */
public class BooksController extends Controller {
    @Inject
    FormFactory formFactory;

    BookService bookService = new BookService();

    public Result bookList() {
        List<Book> booksList = bookService.getAll();

        return ok(views.html.bookList.render(booksList));
    }

    public Result topBooks() {
        return ok(views.html.top10.render());
    }

    public Result hotNew() {
        return ok(views.html.hotNew.render());
    }

    public Result addBook() {
        Form<Book> bookForm = formFactory.form(Book.class);

        return ok(views.html.dashboard.books.add.render(bookForm));
    }

    public Result saveBook() {
        Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();
        /*if(bookForm.hasErrors()) {
            return badRequest(bookForm.render(bookForm));
        }*/
        bookForm.get().save();

        return ok(views.html.dashboard.books.add.render(bookForm));
    }

    public Result bookView(long bookId) {
        Book book = bookService.getBookById(bookId);
        return ok(singleBookView.render(book));

    }
/*    public Result editBookForm() {
        return ok(all.render(bookService.getAll()));
    }*/
    public Result editBookForm(long bookId){
        Book book = bookService.getBookById(bookId);
        Form<Book> bookForm = formFactory.form(Book.class).fill(book);
        return ok(edit.render(bookForm));
    }
    public Result editBook(){
        Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();
        bookForm.get().update();
        return redirect(routes.BooksController.bookList());
    }
    public Result deleteBook(long bookId){
        bookService.getBookById(bookId).delete();
        return redirect(routes.BooksController.bookListDashboard());
    }
    public Result bookListDashboard() {
        List<Book> booksList = bookService.getAll();
        return ok(all.render(booksList));
    }
    public Result availableBooks() {
        List<Book> availableBooks = bookService.getAllAvailableBooks();
        return ok(availableBookList.render(availableBooks));
    }
}
