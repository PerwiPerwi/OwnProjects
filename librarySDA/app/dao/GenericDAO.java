package dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by RENT on 2016-06-11.
 */
public interface GenericDAO <T, PK extends Serializable> {

    //CRUD
    void create(T newObject);
   void update(T object);
    boolean delete(PK primaryKey);
    T getById(PK primaryKey);

    //SPECIFIED Methods
    T getByUserId(PK primaryKey);
    List<T> getAll();

}
