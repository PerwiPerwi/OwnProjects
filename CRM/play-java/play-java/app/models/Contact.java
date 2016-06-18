package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.Date;
@Entity
public class Contact extends Model {

    @Id
    private long id;



    @Column(nullable = false)
    @Constraints.Required(message = "This is field required")
    @Pattern(regexp="^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšśžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŚŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+",
            message = "Wrong Contact Name")
    private String contactName;

    @Valid
    @OneToOne(optional = false)
    private ContactData contactData;

    @ManyToOne(optional = false)
    private User user;

    @Formats.DateTime(pattern = "dd/MM/yyyy")
    private Date registrationDate = new Date();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public ContactData getContactData() {
        return contactData;
    }

    public void setContactData(ContactData contactData) {
        this.contactData = contactData;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

}
