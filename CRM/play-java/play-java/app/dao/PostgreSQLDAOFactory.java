package dao;

/**
 * Created by RENT on 2016-06-15.
 */
public class PostgreSQLDAOFactory extends DAOFactory {
    @Override
    public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    @Override
    public ContactDAO getContactDAO() {
        return new ContactDAOImpl();
    }
}
