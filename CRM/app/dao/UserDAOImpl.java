package dao;

import com.avaje.ebean.Ebean;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDAOImpl implements UserDAO {

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
        String userPassword = user.getPassword();
        String hashedUserPassword = hashPassword(userPassword);
        user.setPassword(hashedUserPassword);
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
    public void update(User newObject, User oldObject) {

    }


    @Override
    public List<User> getAllUsers() {
        return Ebean.find(User.class).where().orderBy("id asc").findList();
    }

    @Override
    public List<String> checkIfDataExist(User userForUpdate, String name, String email) {
        List<String> errors = new ArrayList<>();
        if (userForUpdate == null) {
            if (getUserByEmail(email) != null) {
                errors.add("This e-mail is already registered.");
            } else if (getUserByName(name) != null) {
                errors.add("This name is already registered.");
            }
        } else if (getUserByEmail(email) != null && !userForUpdate.getEmail().equals(email)) {
            errors.add("This e-mail is already registered.");
            return errors;
        }
        return errors;
    }


    @Override
    public User getUserByEmail(String email) {
        User user = Ebean.find(User.class).where().ilike("email", email).findUnique();
        return user;
    }

    @Override
    public void updateUserEmail(User user, User userFromForm) {
        if (!user.getEmail().equals(userFromForm.getEmail())) {
            user.setEmail(userFromForm.getEmail());
            Ebean.update(user);
        }
    }

    @Override
    public void updatePassword(User user, String password) {
        String hashedPassword = hashPassword(password);
        user.setPassword(hashedPassword);
        user.update();
    }

    @Override
    public void setDefaultProfilePicture(User user) {
        user.setProfilPicture("defaultPicture.png");
        user.update();
    }

    @Override
    public void updateProfilePicture(User user, String pictureName) {
        user.setProfilPicture(pictureName);
        user.update();
    }

    @Override
    public void updateUserRole(User user, String role) {
        user.setAccountRole(role);
        user.update();
    }

    @Override
    public User getUserByNameAndEmail(String name, String email) {
        return Ebean.find(User.class).where().ilike("name", name).ilike("email", email).findUnique();
    }

    @Override
    public void updateFirstNameAndLastName(User user, User userFromForm) {
        user.setFirstName(userFromForm.getFirstName());
        user.setLastName(userFromForm.getLastName());
        Ebean.update(user);
    }

    @Override
    public User getUserByName(String name) {
        User user = Ebean.find(User.class).where().ilike("name", name).findUnique();
        return user;
    }

    @Override
    public void updateUserByAdmin(User user, User userFromForm) {
        user.setFirstName(userFromForm.getFirstName());
        user.setLastName(userFromForm.getLastName());
        if (!user.getEmail().equals(userFromForm.getEmail())) {
            System.out.println("IF");
            user.setEmail(userFromForm.getEmail());
        }
        user.setAccountRole(userFromForm.getAccountRole());
        Ebean.update(user);
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

    private String hashPassword(String userPassword) {
        int workload = 12;
        String salt = BCrypt.gensalt(workload);
        String hashed_password = BCrypt.hashpw(userPassword, salt);
        return (hashed_password);
    }

}
