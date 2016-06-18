package com.checkitout.dao;

import java.util.List;

import com.checkitout.model.User;

public interface UserDAO extends GenericDAO <User, Long> {
	   List<User> getAll();
	    User getUserByUsername(String username);
	    boolean updateByAdmin(User user);
	    boolean updateRole(String role,String username);
	    boolean updatePicure(User user);
	    String checkIfEmailExist(String email);
	    String checkIfUsernameExist(String username);
	    public boolean setDefulatPicture(User user);
	    public String getUserRole(String username);
	    public boolean checkMailForUpdate (String email, String username);

	    
	    
}
