package models;

import com.avaje.ebean.Model;
import models.enums.PaymentStatus;
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

    @Column(nullable = false)
    private DateTime paymentDate;

    @Column(columnDefinition = "varchar default 'NOT_PAYED'")
    private String penaltyStatus = "NOT";

    @Column(nullable = false)
    private double ammount;

    @ManyToOne
    @Column(nullable = false)
    private User user;

    // Liczenie dni na podstawie dwoch dat z wypozyczenia       int days = Days.daysBetween(rental.getReturnDate() , rental.getLoanDate()).getDays();


}
