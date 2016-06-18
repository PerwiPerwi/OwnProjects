package dao;

import models.User;

import java.util.List;

/**
 * Created by RENT on 2016-06-15.
 */
public interface UserDAO extends GenericDAO <User, Long> {
    User findByUsernameAndPassword(String name, String password);
    List<User> getAllUsers();
    List<String> checkIfDataExist(String name, String email);
    User getUserByName(String name);
    User getUserByEmail(String email);
}
