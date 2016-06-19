package controllers;

import models.Book;
import models.Rental;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import services.BookService;
import services.RentalService;
import views.html.dashboard.index;

/**
 * Created by RENT on 2016-06-19.
 */
public class RentController extends Controller {

    @Security.Authenticated(SeciurityController.class)
    public Result rentBook(long bookId){
        User user = SeciurityController.getUser();
        BookService bookService = new BookService();
        Book book = bookService.getBookById(bookId);
        RentalService rentalService = new RentalService();
        Rental rental = rentalService.rentBook(user, book);
        book.setRental(rental);
        bookService.changeBookStatus(bookId,"NOT_AVAILABLE");
        book.update();
        return redirect(routes.Application.index());
    }
    @Security.Authenticated(SeciurityController.class)
    public Result getAllUserRents(){
        RentalService rentalService = new RentalService();
        User user = SeciurityController.getUser();

        return ok(index.render(rentalService.getAllRentalsByUserId(user.getId())));
    }
}