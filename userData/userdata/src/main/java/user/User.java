package user;

import java.sql.Date;

/**
 *
 */
public class User {
	
	@Override
	public String toString() {
		return "id = " + id + ", Imie: = " + name + ", email = " + email + ", data rejestracji = " + registrationDate;
	}

	private int id;
	private String name;
	private String email;
	private Date registrationDate;
	
	public User(){
	}
	
	public User(int id, String name, String email, Date registrationDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.registrationDate = registrationDate;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

}
