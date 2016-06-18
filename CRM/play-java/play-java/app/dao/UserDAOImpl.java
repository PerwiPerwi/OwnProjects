package dao;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2016-06-09.
 */
public class UserDAOImpl implements UserDAO {

    private static Model.Finder<Long, User> userFinder = new Model.Finder<Long, User>(User.class);

    @Override
    public User findByUsernameAndPassword(String name, String password) {
        User user = Ebean.find(User.class).where().ilike("name", name).findUnique();
        if (user != null) {
            if (BCrypt.checkpw(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void create(User user) {
        Ebean.insert(user);
    }

    @Override
    public User findById(Long userId) {
        return Ebean.find(User.class).where().idEq(userId).findUnique();

    }

    @Override
    public boolean delete(Long userId) {
        User userForDelete = findById(userId);
        return Ebean.delete(userForDelete);
    }

    @Override
    public void update(User user) {

        Ebean.update(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userFinder.all();
    }

    @Override
    public List<String> checkIfDataExist(String name, String email) {
        List<String> errors = new ArrayList<>();
        if (getUserByName(name) != null) {
            errors.add("This name is already registered.");
        }
        if (getUserByEmail(email) != null) {
            errors.add("This e-mail is already registered.");
        }
        return errors;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = Ebean.find(User.class).where().ilike("email", email).findUnique();
        return user;
    }

    @Override
    public User getUserByName(String name) {
        User user = Ebean.find(User.class).where().ilike("name", name).findUnique();
        return user;
    }

}
