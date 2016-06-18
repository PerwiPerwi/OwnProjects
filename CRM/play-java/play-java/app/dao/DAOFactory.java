package dao;

import exception.NoSuchDbException;

/**
 * Created by RENT on 2016-06-15.
 */
public abstract class DAOFactory {

    private static final int POSTGRESQL_DAO_FACTORY = 1;

    public abstract UserDAO getUserDAO();

    public abstract ContactDAO getContactDAO();


    public static DAOFactory getDAOFactory() {
        DAOFactory factory = null;
        try {
            factory = getDAOFactory(POSTGRESQL_DAO_FACTORY);
        } catch (NoSuchDbException e) {
            e.printStackTrace();
        }
        return factory;
    }

    private static DAOFactory getDAOFactory(int type) throws NoSuchDbException {
        switch (type) {
            case POSTGRESQL_DAO_FACTORY:
                return new PostgreSQLDAOFactory();
            default:
                throw new NoSuchDbException();
        }
    }
}