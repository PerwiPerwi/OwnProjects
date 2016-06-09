package com.checkitout.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Comparator;
import java.util.List;

import com.checkitout.dao.DAOFactory;
import com.checkitout.dao.UserDAO;
import com.checkitout.model.User;

public class UserService {

	public void addUser(String username, String email, String password)
			throws SQLIntegrityConstraintViolationException {
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		String md5pass = encryptPassword(password);
		user.setPassword(md5pass);
		user.setActive(true);
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		userDao.create(user);
	}

	private String encryptPassword(String password) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		digest.update(password.getBytes());
		String md5Password = new BigInteger(1, digest.digest()).toString(16);
		return md5Password;
	}

	public User getUserById(long userId) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		User user = userDao.read(userId);
		return user;
	}

	public User getUserByUsername(String username) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		User user = userDao.getUserByUsername(username);
		return user;
	}

	public List<User> getAllUsers() {

		return getAllUsers(null);

	}

	public List<User> getAllUsers(Comparator<User> comparator) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		List<User> users = userDao.getAll();
		if (comparator != null && users != null) {
			users.sort(comparator);
		}
		return users;
	}

	public void deleteUser(long id) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		userDao.delete(id);
	}

	public void updateByUser(User user) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		userDao.update(user);

	}

	public void updateUserByAdmin(User user) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		userDao.updateByAdmin(user);
	}

	public void updateRole(String role, String username) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDAO = factory.getUserDAO();
		userDAO.updateRole(role, username);
	}

	public boolean updatePictureUrl(User user) {
		boolean result = false;
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDAO = factory.getUserDAO();
		result = userDAO.updatePicure(user);
		return result;
	}

	public boolean updateUserByUser(User user, String password) {
		boolean result = false;
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		String encryptPass = encryptPassword(password);
		user.setPassword(encryptPass);
		result = userDao.update(user);
		return result;

	}

	public String checkIfEmailExist(String email) {
		String tempEmail = "";
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDAO = factory.getUserDAO();
		tempEmail = userDAO.checkIfEmailExist(email);
		if (tempEmail == null) {
			return "";
		}
		return tempEmail;
	}

	public String checkIfUsernameExist(String username) {
		String tempUsername = "";
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDAO = factory.getUserDAO();
		tempUsername = userDAO.checkIfUsernameExist(username);
		if (tempUsername == null) {
			return "";
		}
		return tempUsername;
	}

	public boolean setDefaultPicture(User user) {
		boolean result = false;
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		result = userDao.setDefulatPicture(user);
		return result;

	}

	public String getUserRole(String username) {
		String userRole = "";
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		userRole = userDao.getUserRole(username);
		return userRole;

	}
	public boolean mailExist(String email, String username) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		UserDAO userDao = factory.getUserDAO();
		boolean result = userDao.checkMailForUpdate(email, username);
		return result;

	}
}