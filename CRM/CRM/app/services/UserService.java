package services;

import dao.DAOFactory;
import dao.UserDAO;
import models.User;

import java.util.List;

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

    public List<String> checkIfDataExist(User userForUpdate, String name, String email) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        List<String> errors = userDAO.checkIfDataExist(userForUpdate, name, email);
        return errors;
    }

    public void create(User user) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        firstUpperLetter(user);
        userDAO.create(user);
    }

    public void update(User userForUpdate, User oldUser) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        firstUpperLetter(oldUser);
        userDAO.update(userForUpdate, oldUser);
    }

    public boolean delete(long userId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        return userDAO.delete(userId);
    }

    public void updatePassword(User user, String password) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        userDAO.updatePassword(user, password);
    }

    public void updateUserEmail(User user, User userFromForm) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        userDAO.updateUserEmail(user, userFromForm);
    }

    public void setDefaultProfilePicture(User user) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        userDAO.setDefaultProfilePicture(user);
    }
    public void updateProfilePicture(User userForUpdate, String pictureName){
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        userDAO.updateProfilePicture(userForUpdate, pictureName);

    }

    public void updateFirstNameAndLastName(User userForUpdate, User userFromForm) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        firstUpperLetter(userFromForm);
        userDAO.updateFirstNameAndLastName(userForUpdate, userFromForm);
    }
    public void updateUserRole(User userForUpdate, String role){
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        userDAO.updateUserRole(userForUpdate, role);

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

    public User getUserByNameAndEmail(String name, String email) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        return userDAO.getUserByNameAndEmail(name, email);
    }

    public void updateUserByAdmin(User user, User userFromForm) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        UserDAO userDAO = factory.getUserDAO();
        firstUpperLetter(userFromForm);
        userDAO.updateUserByAdmin(user, userFromForm);
    }


}
