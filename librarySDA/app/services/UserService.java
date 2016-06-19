package services;

import dao.DAOFactory;
import dao.UserDAO;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

/**
 * Created by RENT on 2016-06-11.
 */
public class UserService {

    public User getUserByEmailAndPassword(String email, String password) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        return userDAO.getUserByEmailAndPassword(email, password);
    }

    public User getUserByEmail(String email) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        return userDAO.getUserByEmail(email);
    }

    public User getUserByName(String name) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        return userDAO.getUserByName(name);
    }

    public List<String> checkIfDataExist(User userForUpdate, String email) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        return userDAO.checkIfDataExist(userForUpdate, email);
    }
    public void create(User user){
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        firstUpperLetter(user);
        userDAO.create(user);
    }

    public User getByUserId(Long userId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        return userDAO.getByUserId(userId);
    }

    public boolean delete(Long userId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        return userDAO.delete(userId);
    }

    public List<User> getAllUsers() {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        return userDAO.getAll();
    }

    public void updateFirstNameAndLastName(User user, User userFromForm) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        firstUpperLetter(userFromForm);
        User userUpdated = userDAO.updateFirstNameAndLastName(user, userFromForm);

    }
    public void updateUserPassword(User user, String password){
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        userDAO.updateUserPassword(user, password);

    }
    public void updateUserEmail(User user, User userFromForm){
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        userDAO.updateUserEmail(user, userFromForm);

    }
    public void updateUserByAdmin(User user, User userFromForm) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        firstUpperLetter(userFromForm);
        userDAO.updateUserByAdmin(user,userFromForm);
    }
    public boolean validateEmail(String email){
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        return userDAO.validateEmail(email);
    }

    private void firstUpperLetter(User user) {
        String firstname = user.getFirstName();
        user.setFirstName(firstname.substring(0, 1).toUpperCase() + firstname.substring(1));
        String lastname = user.getLastName();
        user.setLastName(lastname.substring(0, 1).toUpperCase() + lastname.substring(1));
    }
}

