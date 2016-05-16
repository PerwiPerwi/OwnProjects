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

	//private static final Map<Integer, User> users = new HashMap<>();
	/*
	 * static { users.put(1, new User(1, "Rafos")); users.put(3, new User(3,
	 * "Admin")); }
	 */

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
	
	public boolean deleteUser (int id){
		try{
			String query = "delete from users where id=?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (SQLException e){
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
			if(resultSet.next()) {
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

	public boolean updateUser(String name, String mail, int id) {
		String query = "UPDATE users set name=?, email=? where id =?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, mail);
			preparedStatement.setInt(3, id);
			
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
	

	/*
	 * public Set<User> getAll() { return new HashSet<>(users.values()); }
	 */

/*	public Set<User> getAll() {

		return new HashSet<>(users.values());
	}
*/
	/*
	 * public boolean addUser(int id, String name) { if (users.containsKey(id))
	 * { // log.error("User o id=? już istnieje!", id); return false; }
	 * users.put(id, new User(id, name)); return true; }
	 */
/*	public boolean removeUser(int id) {
		if (!users.containsKey(id)) {
			// log.error("User o id=" + id + " nie istnieje!");
			return false;
		}
		users.remove(id);
		return true;
	}*/
}
