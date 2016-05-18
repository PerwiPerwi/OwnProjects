package user;

import lombok.extern.slf4j.Slf4j;
import jdbc.*;

import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

	private Connection conn;

	public UserDAO() {
		conn = DBUtil.getConnection();
	}

	public boolean addUser(String name, String mail) {
		try {
			String query = "insert into users (name, email, registrationDate) values (?,?, NOW() )";
			PreparedStatement preparedStatement = conn.prepareStatement(query);

			preparedStatement.setString(1, name);
			preparedStatement.setString(2, mail);

			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteUser(int id) {
		try {
			String query = "delete from users where id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Optional<User> getUserById(int id) {
		// return Optional.ofNullable(users.get(id));
		User user = new User();
		try {
			String query = "select * from users where id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setRegistrationDate(resultSet.getDate("registrationDate"));
			}
			resultSet.close();
			preparedStatement.close();
			return Optional.of(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.of(null);
	}

	public boolean updateUser(int id, String name, String mail) {
		String query = "UPDATE users set name=?, email=? where id =?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(3, id);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, mail);

			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public List<User> getAllUser() {
		// return Optional.ofNullable(users.get(id));
		List<User> users = new ArrayList<>();
		try {
			String query = "select * from users";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("email"));
				user.setRegistrationDate(resultSet.getDate("registrationDate"));
				users.add(user);

			}
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
