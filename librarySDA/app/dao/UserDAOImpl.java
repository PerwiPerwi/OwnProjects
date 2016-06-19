package dao;

import com.avaje.ebean.Ebean;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by RENT on 2016-06-11.
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        User user = Ebean.find(User.class).where().ilike("email", email).findUnique();
        if (user != null) {
            if (BCrypt.checkpw(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<String> checkIfDataExist(User userForUpdate, String email) {
        List<String> errors = new ArrayList<>();
        if (userForUpdate == null) {
            if (getUserByEmail(email) != null) {
                errors.add("This e-mail is already registered.");
                return errors;
            }
            if (getUserByEmail(email) != null && !userForUpdate.getEmail().equals(email)) {
                errors.add("This e-mail is already registered.");
                return errors;
            }
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

    private String hashPassword(String userPassword) {
        int workload = 12;
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(userPassword, salt);

        return hashed_password;
    }


    @Override
    public User updateFirstNameAndLastName(User user, User userFromForm) {
        user.setFirstName(userFromForm.getFirstName());
        user.setLastName(userFromForm.getLastName());
        Ebean.update(user);
        return user;
    }

    @Override
    public void updateUserPassword(User user, String password) {
        String hashedPassword = hashPassword(password);
        user.setPassword(hashedPassword);
        Ebean.update(user);
    }

    @Override
    public void updateUserEmail(User user, User userFromForm) {
        if (!user.getEmail().equals(userFromForm.getEmail())) {
            user.setEmail(userFromForm.getEmail());
            Ebean.update(user);
        }
    }

    @Override
    public boolean validateEmail(String email) {
        boolean result = false;
        String pattern = "^(.+)@(.+)$";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(email);
        if (matcher.find()) {
            result = true;
            return result;
        }
        return result;
    }

    @Override
    public void updateUserByAdmin(User user, User userFromForm) {
        user.setFirstName(userFromForm.getFirstName());
        user.setLastName(userFromForm.getLastName());
        if (!user.getEmail().equals(userFromForm.getEmail())) {
            user.setEmail(userFromForm.getEmail());
        }
        user.setAccountRole(userFromForm.getAccountRole());
        Ebean.update(user);
    }


    @Override
    public void create(User user) {
        String userPassword = user.getPassword();
        String hashedPassword = hashPassword(userPassword);
        user.setPassword(hashedPassword);
        Ebean.insert(user);
    }

    @Override
    public void update(User user) {
        Ebean.update(user);
        ;
    }

    @Override
    public boolean delete(Long userId) {
        User user = getByUserId(userId);
        return Ebean.delete(user);
    }

    @Override
    public User getById(Long primaryKey) {
        return null;
    }

    @Override
    public User getByUserId(Long userId) {
        return Ebean.find(User.class).where().idEq(userId).findUnique();

    }

    @Override
    public List<User> getAll() {
        return Ebean.find(User.class).where()
                .orderBy("id asc")
                .findList();
    }
}
