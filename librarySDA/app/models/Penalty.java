package models;

import com.avaje.ebean.Model;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by RENT on 2016-06-11.
 */
@Entity
public class Penalty extends Model {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    private DateTime paymentDate;

    @Column(columnDefinition = "varchar default 'NOT_PAYED'")
    private String penaltyStatus = "NOT_PAYED";

    @Column(nullable = false)
    private double ammount;

    @ManyToOne
    @Column(nullable = false)
    private User user;

    @OneToOne
    private Rental rental;

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(DateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPenaltyStatus() {
        return penaltyStatus;
    }

    public void setPenaltyStatus(String penaltyStatus) {
        this.penaltyStatus = penaltyStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }
// Liczenie dni na podstawie dwoch dat z wypozyczenia       int days = Days.daysBetween(rental.getReturnDate() , rental.getLoanDate()).getDays();


}
