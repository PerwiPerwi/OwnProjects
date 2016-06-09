package com.checkitout.dao;

import com.checkitout.model.Vote;

public interface VoteDAO extends GenericDAO<Vote, Long> {
	public Vote getVoteByUserIdDiscoveryId(long userId, long discoveryId);
}
