package com.checkitout.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.checkitout.model.Vote;
import com.checkitout.model.VoteType;
import com.checkitout.util.ConnectionProvider;

public class VoteDAOImpl implements VoteDAO {

	private static final String CREATE_VOTE = "INSERT INTO vote(discovery_id, user_id, date, type) "
			+ "VALUES (:discovery_id, :user_id, :date, :type);";
	private static final String READ_VOTE = "SELECT vote_id, discovery_id, user_id, date, type "
			+ "FROM vote WHERE vote_id = :vote_id;";
	private static final String READ_VOTE_BY_DISCOVERY_USE_IDS = "SELECT vote_id, discovery_id, user_id, date, type "
			+ "FROM vote WHERE user_id = :user_id AND discovery_id = :discovery_id;";
	private static final String UPDATE_VOTE = "UPDATE vote SET date=:date, type=:type WHERE vote_id=:vote_id;";

	NamedParameterJdbcTemplate template;

	public VoteDAOImpl() {
		template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
	}

	public Vote create(Vote vote) {
		Vote voteResult = new Vote(vote);
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("discovery_id", voteResult.getDiscoveryId());
		paramMap.put("user_id", voteResult.getUserId());
		paramMap.put("date", voteResult.getTimestamp());
		paramMap.put("type", voteResult.getVoteType().toString());
		KeyHolder holder = new GeneratedKeyHolder();
		SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
		int update = template.update(CREATE_VOTE, paramSource, holder);
		if (update > 0) {
			voteResult.setId((Long) holder.getKey());
		}
		return voteResult;
	}

	public Vote read(Long primaryKey) {
		SqlParameterSource paramSource = new MapSqlParameterSource("vote_id", primaryKey);
		Vote vote = template.queryForObject(READ_VOTE, paramSource, new VoteRowMapper());
		return vote;
	}

	    public boolean update(Vote vote) {
	        boolean result = false;
	        Map<String, Object> paramMap = new HashMap<>();
	        paramMap.put("date", vote.getTimestamp());
	        paramMap.put("type", vote.getVoteType().toString());
	        paramMap.put("vote_id", vote.getId());
	        SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
	        int update = template.update(UPDATE_VOTE, paramSource);
	        if(update > 0) {
	            result = true;
	        }
	        return result;
	    }

	public boolean delete(Long key) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Vote> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

    public Vote getVoteByUserIdDiscoveryId(long userId, long discoveryId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_id", userId);
        paramMap.put("discovery_id", discoveryId);
        SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
        Vote vote = null;
        try {
            vote = template.queryForObject(READ_VOTE_BY_DISCOVERY_USE_IDS, paramSource, new VoteRowMapper());
        } catch(EmptyResultDataAccessException e) {
            //vote not found
        }
        return vote;
    }

	private class VoteRowMapper implements RowMapper<Vote> {

		@Override
		public Vote mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
			Vote vote = new Vote();
			vote.setId(resultSet.getLong("vote_id"));
			vote.setDiscoveryId(resultSet.getLong("discovery_id"));
			vote.setUserId(resultSet.getLong("user_id"));
			vote.setTimestamp(resultSet.getTimestamp("date"));
			vote.setVoteType(VoteType.valueOf(resultSet.getString("type")));
			return vote;
		}

	}

}
