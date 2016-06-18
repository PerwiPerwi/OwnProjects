package dao;

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
