package com.checkitout.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.checkitout.model.Discovery;
import com.checkitout.model.User;
import com.checkitout.model.Vote;
import com.checkitout.model.VoteType;
import com.checkitout.service.DiscoveryService;
import com.checkitout.service.VoteService;

@WebServlet("/vote")
public class VoteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User loggedUser = (User) req.getSession().getAttribute("user");
		if (loggedUser != null) {
			VoteType voteType = VoteType.valueOf(req.getParameter("vote"));
			long loggedUserId = loggedUser.getId();
			long discoveryId = Long.parseLong(req.getParameter("discovery_id"));
			updateVote(loggedUserId, voteType, discoveryId);

		}

		resp.sendRedirect("home");
	}

	private void updateVote(long userId, VoteType voteType, long discoveryId) {
		VoteService voteService = new VoteService();
		Vote existingVote = voteService.getVoteByDiscoveryUserId(discoveryId, userId);
		Vote updatedVote = voteService.addOrUpdateVote(discoveryId, userId, voteType);
		if (existingVote != updatedVote || !updatedVote.equals(existingVote)) {
			updateDiscovery(discoveryId, existingVote, updatedVote);
		}

	}

	private void updateDiscovery(long discoveryId, Vote oldVote, Vote newVote) {
		DiscoveryService discoveryService = new DiscoveryService();
		Discovery discoveryById = discoveryService.getDiscoveryById(discoveryId);

		Discovery updatedDiscovery = null;
		if (oldVote == null && newVote != null) {
			updatedDiscovery = addDiscoveryVote(discoveryById, newVote.getVoteType());
		} else if (oldVote != null && newVote != null) {
			updatedDiscovery = removeDiscovery(discoveryById, oldVote.getVoteType());
			updatedDiscovery = addDiscoveryVote(updatedDiscovery, newVote.getVoteType());
		}
		discoveryService.updateDiscovery(updatedDiscovery);
	}

	private Discovery addDiscoveryVote(Discovery discovery, VoteType vote) {
		Discovery discoveryCopy = new Discovery(discovery);
		if (vote == VoteType.VOTE_UP) {
			discoveryCopy.setUpVote(discoveryCopy.getUpVote()+1);
		} else if (vote == VoteType.VOTE_DOWN) {
			discoveryCopy.setDownVote(discoveryCopy.getDownVote()+1);
		}
		return discoveryCopy;
	}

	private Discovery removeDiscovery(Discovery discovery, VoteType vote) {
		Discovery discoveryCopy = new Discovery(discovery);
		if (vote == VoteType.VOTE_UP) {
			discoveryCopy.setUpVote(discoveryCopy.getUpVote() - 1);
		} else if (vote == VoteType.VOTE_DOWN) {
			discoveryCopy.setDownVote(discoveryCopy.getDownVote() - 1);
		}
		return discoveryCopy;
	}
}
