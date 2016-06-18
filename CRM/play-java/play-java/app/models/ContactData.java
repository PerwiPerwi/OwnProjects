package models;

import com.avaje.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class ContactData extends Model {

    @Id
    private long id;
    @Column(nullable = false)
    @Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$"
            ,message = "Wrong Adres Email")
    private String email;

    @Column
    @Pattern(regexp="^[\\p{L}\\s'.-]+$",message = "Wrong Country!")
    private String country;

    @Column
    @Pattern(regexp="\\d{2}-\\d{3}",message = "Wrong Zip Code, Example 00-000")
    private String zipCode;

    @Pattern(regexp="^[\\p{L}\\s'.-]+$",message = "Wrong City")
    private String city;

    @Column
    @Pattern(regexp="([A-Za-z]+ [0-9\\\\/]+)",message = "Wrong Street")
    private String street;

    @Column(length = 4000)
    private String description;

    @Column
    @Pattern(regexp="^(\\d{7,15})$",message = "Phone Number must be at least 7-characters text and 15-characters max length")
    private String phoneNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
