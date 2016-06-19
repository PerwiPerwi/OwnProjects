package models;

import com.avaje.ebean.Model;
import models.enums.AccountRole;
import models.enums.AccountStatus;
import org.joda.time.DateTime;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by RENT on 2016-06-11.
 */
@Entity
@Table(name = "users")
public class User extends Model {

    @Id
    private long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "varchar default 'ACTIVE'")
    private String accountStatus = "ACTIVE";

    @Column(columnDefinition = "varchar default 'USER'")
    private String accountRole = "USER";

    @Formats.DateTime(pattern = "dd/MM/yyyy")
    private DateTime registrationDate = new DateTime();

    public String getAccountRole() {
        return accountRole;
    }
    @OneToMany(mappedBy = "user")
    private Rental rental;

    @OneToMany(mappedBy = "user")
    private Penalty penalty;

    public void setAccountRole(String accountRole) {
        this.accountRole = accountRole;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }


    public Penalty getPenalty() {
        return penalty;
    }

    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(DateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }




}
