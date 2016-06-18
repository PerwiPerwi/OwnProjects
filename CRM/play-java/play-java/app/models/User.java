package models;

import com.avaje.ebean.Model;
import java.util.Date;
import play.data.format.Formats;
import play.data.validation.Constraints;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "account")
public class User extends Model {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, unique = true)
    @Constraints.Required(message = "This is field required")
    @Pattern(regexp="^[a-zA-Z0-9._-]{3,}$",
            message = "Wrong Name")
    private String name;

    @Column(nullable = false)
    @Constraints.Required(message = "This is field required")
    @Pattern(regexp="^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšśžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŚŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+",
            message = "Wrong First Name")
    private String firstName;

    @Column(nullable = false)
    @Constraints.Required(message = "This is field required")
    @Pattern(regexp="^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšśžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŚŻŹÑßÇŒÆČŠŽ∂ð ,.'-]+",
            message = "Wrong Last Name")
    private String lastName;

    @Column(nullable = false)
    @Constraints.Required(message = "This is field required")
    private String password;

    @Column(columnDefinition = "varchar default 'USER'")
    private String accountRole = "USER";

    @Constraints.Required(message = "This is field required")
    @Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$"
            ,message = "Wrong Adres Email")
    @Column(nullable = false, unique = true)
    private String email;

    @Column(columnDefinition = "varchar default 'defaultPicture.png'")
    private String profilPicture = "defaultPicture.png";

    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL)
    private List<Contact> contactList;

    @Formats.DateTime(pattern = "dd/MM/yyyy")
    private Date registrationDate = new Date();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountRole() {
        return accountRole;
    }

    public void setAccountRole(String accountRole) {
        this.accountRole = accountRole;
    }


    public String getProfilPicture() {
        return profilPicture;
    }

    public void setProfilPicture(String profilPicture) {
        this.profilPicture = profilPicture;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }


}
