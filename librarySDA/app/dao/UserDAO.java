package dao;

        import models.User;

        import java.util.List;

/**
 * Created by RENT on 2016-06-11.
 */
public interface UserDAO extends GenericDAO<User, Long> {
    User getUserByUsername(String username);
    User getUserByEmailAndPassword(String email, String password);
    List<String> checkIfDataExist(User userForUpdate, String email);
    User getUserByEmail(String email);
    User getUserByName(String name);
    User updateFirstNameAndLastName(User user, User userFromForm);
    void updateUserPassword(User user, String password);
    void updateUserEmail(User user, User userFromForm);
    boolean validateEmail(String email);
    void updateUserByAdmin(User user, User userFromForm);


}
