package com.checkitout.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.checkitout.model.User;
import com.checkitout.util.ConnectionProvider;

public class UserDAOImpl implements UserDAO {

	private final String CREATE_USER = "INSERT INTO user(username, email, password, is_active) VALUES(:username, :email, :password, :active);";
	private final String READ_USER = "SELECT user_id, username, email, password, is_active, picture_url FROM user WHERE user_id =:user_id ";
	private final String READ_USER_BY_USERNAME = "SELECT user_id, username, email,password, is_active, picture_url FROM user WHERE username = :username";
	private final String READ_ALL = "SELECT user_id, user.username, email,is_active, user_role.role_name FROM check_it.user INNER JOIN check_it.user_role ON user.username = user_role.username;";
	private final String CHECK_EMAIL_FOR_UPDATE = "SELECT email FROM user WHERE email=:email AND email NOT IN( SELECT email FROM user WHERE username=:username);";
	private final String USER_ROLE_QUERY = "INSERT INTO user_role(username) VALUES(:username)";
	private final String READ_USER_ROLE = "SELECT role_name FROM check_it.user_role WHERE username=:username;";
	private final String DELETE_USER = "DELETE FROM user WHERE user_id=:user_id;";
	private final String UPDATE_USER_BY_USER = "UPDATE user SET password=:password, email=:email WHERE username=:username";
	private final String UPDATE_USER_BY_ADMIN = "UPDATE user SET username=:username, email=:email, is_active=:is_active WHERE user_id=:user_id";
	private final String UPDATE_USER_ROLE = "UPDATE user_role SET role_name=:role_name WHERE username=:username";
	private final String UPDATE_PICTURE_URL = "UPDATE user SET picture_url=:picture_url WHERE username=:username";
	private final String READ_USER_USERNAME = "SELECT username FROM user WHERE username=:username";
	private final String READ_USER_EMAIL = "SELECT email FROM user WHERE email=:email";
	private final String SET_DEFAULT_PICTURE = "UPDATE user SET picture_url=:picture_url WHERE username=:username ";
	
	private NamedParameterJdbcTemplate template;

	public UserDAOImpl() {
		template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
	}

	public User create(User user) {
		User resultUser = new User(user);
		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
		int update = template.update(CREATE_USER, paramSource, holder);
		if (update > 0) {
			resultUser.setId((Long) holder.getKey());
			setPrivigiles(resultUser);
		}
		return resultUser;
	}

	private void setPrivigiles(User user) {
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
		template.update(USER_ROLE_QUERY, paramSource);
	}

	public User read(Long primaryKey) {
		User resultUser = null;
		SqlParameterSource paramSource = new MapSqlParameterSource("user_id", primaryKey);
		resultUser = template.queryForObject(READ_USER, paramSource, new UserRowMapper());
		return resultUser;
	}
	public boolean updateByAdmin(User user) {
		boolean result = false;
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("username", user.getUsername());
		paramMap.put("email", user.getEmail());
		paramMap.put("is_active", user.isActive());
		paramMap.put("user_id", user.getId());
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		int rowsAffected = template.update(UPDATE_USER_BY_ADMIN, paramSource);
		if(rowsAffected > 0){
			result = true;
		}
		return result;
	}
	
	public boolean updateRole(String role,String username){
		boolean result = false;
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("role_name", role);
		paramMap.put("username", username);
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		int rowsAffected = template.update(UPDATE_USER_ROLE, paramSource);
		if(rowsAffected > 0){
			result = true;
		}
		
		return result;
		
	}

	public boolean delete(Long key) {
		boolean result = false;
		SqlParameterSource paramSource = new MapSqlParameterSource("user_id", key);
		int rowsAffected = template.update(DELETE_USER, paramSource);
		if(rowsAffected > 0){
			result = true;
		}
		return result;
	}

	public List<User> getAll() {
		List<User> users = template.query(READ_ALL, new SpecifiedUserMapRow());
		
		return users;
	}

	public User getUserByUsername(String username) {
		User resultUser = null;
		SqlParameterSource paramSource = new MapSqlParameterSource("username", username);
		resultUser = template.queryForObject(READ_USER_BY_USERNAME, paramSource, new UserRowMapper());
		return resultUser;
	}
	
	@Override
	public boolean updatePicure(User user) {
		boolean result = false;
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("picture_url", user.getPictureUrl());
		paramMap.put("username", user.getUsername());
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		int rowsAffected = template.update(UPDATE_PICTURE_URL, paramSource);
		if(rowsAffected > 0){
			result = true;
		}
		return result;
	}
	@Override
	public boolean update(User user) {
		boolean result = false;
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("password", user.getPassword());
		paramMap.put("email", user.getEmail());
		paramMap.put("username", user.getUsername());
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		int rowsAffected = template.update(UPDATE_USER_BY_USER, paramSource);
		if(rowsAffected > 0){
			result = true;
		}
		return result;
	}

	@Override
	public String checkIfUsernameExist(String username) {
		String tempUsername ="";
		SqlParameterSource paramSource = new MapSqlParameterSource("username", username);
		List<String> userUsername = template.query(READ_USER_USERNAME, paramSource, new userUsernameMapRow());
		if (!userUsername.isEmpty()) {
			tempUsername = userUsername.get(0);
		}
		return tempUsername;
	}
	
	
	@Override
	public String checkIfEmailExist(String email) {
		String tempEmail ="";
		SqlParameterSource paramSource = new MapSqlParameterSource("email", email);
		List<String> userEmail = template.query(READ_USER_EMAIL, paramSource, new userEmailMapRow());
		if (!userEmail.isEmpty()) {
			tempEmail = userEmail.get(0);
		}
		return tempEmail;

	}
	
	@Override
	public boolean setDefulatPicture(User user) {
		boolean result = false;
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("picture_url", user.getPictureUrl());
		paramMap.put("username", user.getUsername());
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		int rowsAffected = template.update(SET_DEFAULT_PICTURE, paramSource);
		if(rowsAffected > 0){
			result = true;
		}
		return result;
	}
	
	@Override
	public String getUserRole(String username) {
		String userRole = "";
		SqlParameterSource paramSource = new MapSqlParameterSource("username", username);
		List<String> userRoleList = template.query(READ_USER_ROLE, paramSource, new userRoleMapRow());
		if (!userRole.isEmpty()) {
			userRole = userRoleList.get(0);
		}
		return userRole;
		
	}
	@Override
	public boolean checkMailForUpdate(String email, String username) {
		boolean result = false;
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("email", email);
		paramMap.put("username", username);
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		List<String> mails = template.query(CHECK_EMAIL_FOR_UPDATE, paramSource, new userEmailMapRow());
		if(mails.isEmpty()){
			result = true;
			return result;
		}
		return result;
	}

		
	
	private class UserRowMapper implements RowMapper<User> {

		public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			User user = new User();
			user.setId(resultSet.getLong("user_id"));
			user.setEmail(resultSet.getString("email"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			user.setPictureUrl(resultSet.getString("picture_url"));
			return user;
		}

	}

	private class SpecifiedUserMapRow implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			User user = new User();
			user.setId(resultSet.getLong("user_id"));
			user.setEmail(resultSet.getString("email"));
			user.setUsername(resultSet.getString("username"));
			user.setActive(resultSet.getBoolean("is_active"));
			user.setRole(resultSet.getString("role_name"));
			return user;
		}
	}
	
	private class userUsernameMapRow implements RowMapper<String> {

		@Override
		public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			String username = resultSet.getString("username");
			return username;
		}
	}
	private class userRoleMapRow implements RowMapper<String> {

		@Override
		public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			String userRole = resultSet.getString("role_name");
			return userRole;
		}
	}
	
	private class userEmailMapRow implements RowMapper<String> {

		@Override
		public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			String email = resultSet.getString("email");
			return email;
		}
	}

}
