package dao;

import java.io.Serializable;

public interface GenericDAO<T, PK extends Serializable> {
    void create(T object);

    T findById(PK primaryKey);

    boolean delete(PK primaryKey);

    void update(T newObject, T oldObject);
}
