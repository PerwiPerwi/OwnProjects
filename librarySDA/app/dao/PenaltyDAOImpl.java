package dao;

import models.Penalty;

import java.util.List;

/**
 * Created by RENT on 2016-06-11.
 */
public class PenaltyDAOImpl implements PenaltyDAO {
    @Override
    public void create(Penalty newObject) {
    }

    @Override
    public void update(Penalty object) {
    }

    @Override
    public boolean delete(Long primaryKey) {
        return false;
    }

    @Override
    public Penalty getById(Long primaryKey) {
        return null;
    }

    @Override
    public Penalty getByUserId(Long primaryKey) {
        return null;
    }

    @Override
    public List<Penalty> getAll() {
        return null;
    }
}
