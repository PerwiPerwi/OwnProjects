package com.checkitout.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.checkitout.model.Discovery;
import com.checkitout.model.User;
import com.checkitout.util.ConnectionProvider;

public class DiscoveryDAOImpl implements DiscoveryDAO {

	private final String CREATE_DISCOVERY = "INSERT INTO discovery (name, description,url,user_id,date, up_vote, down_vote) "
			+ "VALUES (:name, :description, :url, :user_id, :date, :up_vote, :down_vote);";
	private final String READ_ALL_DISCOVERIES = "SELECT user.user_id, username, email, is_active, password, discovery_id, name, description, url, date, up_vote, down_vote "
			+ "FROM discovery LEFT JOIN user ON discovery.user_id=user.user_id;";
	private final String READ_DISCOVERY = "SELECT user.user_id, username, email, is_active, password, discovery_id, name, description, url, date, up_vote, down_vote "
			+ "FROM discovery LEFT JOIN user ON discovery.user_id=user.user_id WHERE discovery_id=:discovery_id;";
	private final String UPDATE_DISCOVERY = "UPDATE discovery SET name=:name, description=:description, url=:url, user_id=:user_id, date=:date, up_vote=:up_vote, down_vote=:down_vote "
			+ "WHERE discovery_id=:discovery_id;";
	private final String DELETE_DISCOVERY = "DELETE FROM check_it.discovery WHERE discovery_id=:discovery_id;";
	
	NamedParameterJdbcTemplate template;

	public DiscoveryDAOImpl() {
		template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
	}

	public Discovery create(Discovery discovery) {
		Discovery resultDiscovery = new Discovery();
		KeyHolder holder = new GeneratedKeyHolder();
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", discovery.getName());
		paramMap.put("description", discovery.getDescription());
		paramMap.put("url", discovery.getUrl());
		paramMap.put("user_id", discovery.getUser().getId());
		paramMap.put("date", discovery.getTimestamp());
		paramMap.put("up_vote", discovery.getUpVote());
		paramMap.put("down_vote", discovery.getDownVote());
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		int update = template.update(CREATE_DISCOVERY, paramSource, holder);
		if (update > 0) {
			resultDiscovery.setId((Long) holder.getKey());
		}
		return resultDiscovery;
	}

	public Discovery read(Long primaryKey) {
		SqlParameterSource paramSource = new MapSqlParameterSource("discovery_id", primaryKey);
		Discovery discovery = template.queryForObject(READ_DISCOVERY, paramSource, new DiscoveryRowMapper());
		return discovery;
	}

    public boolean update(Discovery discovery) {
        boolean result = false;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("discovery_id", discovery.getId());
        paramMap.put("name", discovery.getName());
        paramMap.put("description", discovery.getDescription());
        paramMap.put("url", discovery.getUrl());
        paramMap.put("user_id", discovery.getUser().getId());
        paramMap.put("date", discovery.getTimestamp());
        paramMap.put("up_vote", discovery.getUpVote());
        paramMap.put("down_vote", discovery.getDownVote());
        SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
        int update = template.update(UPDATE_DISCOVERY, paramSource);
        if(update > 0) {
            result = true;
        }
        return result;
    }
 
	public boolean delete(Long key) {
		boolean result = false;
		SqlParameterSource paramSource = new MapSqlParameterSource("discovery_id", key);
		int rowsAffected = template.update(DELETE_DISCOVERY, paramSource);
		if(rowsAffected > 0){
			result = true;
		}
		return result;
	}

	public List<Discovery> getAll() {
		List<Discovery> discoveryList = template.query(READ_ALL_DISCOVERIES, new DiscoveryRowMapper());
		return discoveryList;
	}

	private class DiscoveryRowMapper implements RowMapper<Discovery> {

		@Override
		public Discovery mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
			Discovery discovery = new Discovery();
			discovery.setId(resultSet.getLong("discovery_id"));
			discovery.setName(resultSet.getString("name"));
			discovery.setDescription(resultSet.getString("description"));
			discovery.setTimestamp(resultSet.getTimestamp("date"));
			discovery.setUrl(resultSet.getString("url"));
			discovery.setUpVote(resultSet.getInt("up_vote"));
			discovery.setDownVote(resultSet.getInt("down_vote"));
			User user = new User();
			user.setId(resultSet.getLong("user_id"));
			user.setUsername(resultSet.getString("username"));
			user.setEmail(resultSet.getString("email"));
			user.setPassword(resultSet.getString("password"));
			discovery.setUser(user);

			return discovery;
		}

	}
}
