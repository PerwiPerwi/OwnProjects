package com.checkitout.service;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.checkitout.dao.DAOFactory;
import com.checkitout.dao.DiscoveryDAO;
import com.checkitout.model.Discovery;
import com.checkitout.model.User;

public class DiscoveryService {

	public void addDiscovery(String name, String desc, String url, User user) {
		Discovery discovery = createDiscoveryObject(name, desc, url, user);
		DAOFactory factory = DAOFactory.getDAOFactory();
		DiscoveryDAO discoveryDAO = factory.getDiscoveryDAO();
		discoveryDAO.create(discovery);
	}

	private Discovery createDiscoveryObject(String name, String desc, String url, User user) {
		Discovery discovery = new Discovery();
		discovery.setName(name);
		discovery.setDescription(desc);
		discovery.setUrl(url);
		User userCopy = new User(user);
		discovery.setUser(userCopy);
		discovery.setTimestamp(new Timestamp(new Date().getTime()));
		return discovery;
	}

	public List<Discovery> getAllDiscovieres() {

		return getAllDiscoveries(null);
	}

	public boolean updateDiscovery(Discovery discovery) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		DiscoveryDAO discoveryDao = factory.getDiscoveryDAO();
		boolean result = discoveryDao.update(discovery);
		return result;
	}

	public Discovery getDiscoveryById(Long discoveryId) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		DiscoveryDAO discoveryDAO = factory.getDiscoveryDAO();
		Discovery discovery = discoveryDAO.read(discoveryId);
		return discovery;
	}

	public List<Discovery> getAllDiscoveries(Comparator<Discovery> comparator) {
		DAOFactory factory = DAOFactory.getDAOFactory();
		DiscoveryDAO discoveryDao = factory.getDiscoveryDAO();
		List<Discovery> discoveries = discoveryDao.getAll();
		if (comparator != null && discoveries != null) {
			discoveries.sort(comparator);
		}
		return discoveries;

	}
	
	public boolean deleteDiscovery(long discoveryId){
		boolean result = false;
		DAOFactory factory = DAOFactory.getDAOFactory();
		DiscoveryDAO discoveryDao = factory.getDiscoveryDAO();
		result = discoveryDao.delete(discoveryId);
		return result;
	}
}
