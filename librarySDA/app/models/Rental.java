package models;

import com.avaje.ebean.Model;
import models.enums.RentalStatus;
import org.joda.time.DateTime;
import play.data.format.Formats;

import javax.persistence.*;

/**
 * Created by RENT on 2016-06-11.
 */
@Entity
public class Rental extends Model {

    @Id
    private long id;

    @Formats.DateTime(pattern = "dd/MM/yyyy")
    private DateTime loanDate = new DateTime();

    @Formats.DateTime(pattern = "dd/MM/yyyy")
    private DateTime returnDate = loanDate.plusDays(7);

    @Column(columnDefinition = "varchar default 'NOT_RETURNED'")
    private String rentalStatus = "NOT RETURNED";

    @OneToOne
    private Penalty penalty;

    @ManyToOne
    private Book book;

    @ManyToOne
    @Column(nullable = false)
    private User user;

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(DateTime loanDate) {
        this.loanDate = loanDate;
    }

    public Penalty getPenalty() {
        return penalty;
    }

    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
    }

    public String getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(String rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public DateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(DateTime returnDate) {
        this.returnDate = returnDate;
    }

}
