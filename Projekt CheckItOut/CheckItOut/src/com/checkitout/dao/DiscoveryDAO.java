package com.checkitout.dao;

import java.util.List;

import com.checkitout.model.Discovery;

public interface DiscoveryDAO extends GenericDAO<Discovery, Long> {
List<Discovery> getAll();
}
