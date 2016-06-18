package dao;

import models.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User, Long> {
    User findByUsernameAndPassword(String name, String password);

    List<User> getAllUsers();

    List<String> checkIfDataExist(String name, String email);

    User getUserByName(String name);

    User getUserByEmail(String email);

    void updateFirstNameAndLastName(User userForUpdate, User userFromForm);

    boolean validateEmail(String email);

    void updateEmail(User user, String email);

    void updatePassword(User userForUpdate, String password);

    void setDefaultProfilePicture(User userForUpdate);

    void updateProfilePicture(User userForUpdate, String pictureName);

    void updateUserRole(User userForUpdate, String role);

}
