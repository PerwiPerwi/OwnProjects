package dao;

import models.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User, Long> {
    User findByUsernameAndPassword(String name, String password);

    List<User> getAllUsers();

    List<String> checkIfDataExist(User userForUpdate, String name, String email);

    User getUserByName(String name);

    User getUserByEmail(String email);

    void updateFirstNameAndLastName(User user, User userFromForm);

    boolean validateEmail(String email);

    void updateUserEmail(User user, User userFromForm);

    void updatePassword(User userForUpdate, String password);

    void setDefaultProfilePicture(User userForUpdate);

    void updateProfilePicture(User userForUpdate, String pictureName);

    void updateUserRole(User userForUpdate, String role);

    User getUserByNameAndEmail(String name, String email);

    void updateUserByAdmin(User user, User userFromForm);

}
