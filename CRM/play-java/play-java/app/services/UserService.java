package services;

import dao.DAOFactory;
import dao.PostgreSQLDAOFactory;
import dao.UserDAO;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

/**
 * Created by RENT on 2016-06-16.
 */
public class UserService {

    public User findByUsernameAndPassword(String name, String password) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        User user = userDAO.findByUsernameAndPassword(name, password);
        return user;
    }

    public User findById(long userId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        User user = userDAO.findById(userId);
        return user;
    }

    public List<User> getAllUsers() {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        List<User> usersList = userDAO.getAllUsers();
        return usersList;
    }

    public User getUserByEmail(String email) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        User user = userDAO.getUserByEmail(email);
        return user;
    }

    public User getUserByName(String name) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        User user = userDAO.getUserByName(name);
        return user;
    }


    public List<String> checkIfDataExist(String name, String email) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        List<String> errors = userDAO.checkIfDataExist(name, email);
        return errors;
    }

    public void create(User user){
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        String userPassword = user.getPassword();
        String hashedPassword = hashPassword(userPassword);
        user.setPassword(hashedPassword);
        firstUpperLetter(user);
        userDAO.create(user);
    }

    public void update(User user){
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        firstUpperLetter(user);
        userDAO.update(user);
 }
    public boolean delete (long userId){
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        return userDAO.delete(userId);
    }

    private String hashPassword(String userPassword) {
        int workload = 12;
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(userPassword, salt);
        return (hashed_password);
    }

    private void firstUpperLetter(User user) {

        String firstname = user.getFirstName();
        user.setFirstName(firstname.substring(0, 1).toUpperCase() + firstname.substring(1));

        String lastname = user.getLastName();
        user.setLastName(lastname.substring(0, 1).toUpperCase() + lastname.substring(1));

        String name = user.getName();
        user.setName(name.substring(0, 1).toUpperCase() + name.substring(1));

        String email = user.getEmail();
        user.setEmail(email.substring(0, 1).toUpperCase() + email.substring(1));
    }



}
