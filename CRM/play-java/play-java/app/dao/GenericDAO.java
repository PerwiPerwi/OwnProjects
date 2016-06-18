package dao;

import models.User;

import java.io.Serializable;

/**
 * Created by RENT on 2016-06-17.
 */
public interface GenericDAO <T, PK extends Serializable> {
    void create(T object);
    T findById(PK primaryKey);
    boolean delete(PK primaryKey);
    void update (T object);
}
