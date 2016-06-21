package controllers;

import models.Book;
import models.Penalty;
import models.Rental;
import models.User;
import org.joda.time.DateTime;
import org.joda.time.Days;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import services.BookService;
import services.PenaltyService;
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
        book.update();
        return redirect(routes.Application.index());
    }
    @Security.Authenticated(SeciurityController.class)
    public Result getAllUserRents(){
        RentalService rentalService = new RentalService();
        User user = SeciurityController.getUser();

        return ok(index.render(rentalService.getAllNotReturnedUserRentalsByUserId(user.getId())));
    }
    @Security.Authenticated(SeciurityController.class)
    public Result returnBook(long rentalId){
        PenaltyService penaltyService = new PenaltyService();
        RentalService rentalService = new RentalService();
        Rental rental = rentalService.getRentalById(rentalId);
        //int days = Days.daysBetween(rental.getReturnDate(), new DateTime()).getDays();
        int days = Days.daysBetween(new DateTime(), rental.getReturnDate()).getDays();
        if(days >= 1){
            Penalty penalty = penaltyService.createPenalty(rental.getUser(), rental);
            rentalService.returnRental(rental, rental.getBook());
            return redirect(routes.RentController.getAllUserRents());
        }
        rentalService.returnRental(rental, rental.getBook());
        return redirect(routes.RentController.getAllUserRents());
    }

}