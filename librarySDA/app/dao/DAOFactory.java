package dao;

import exceptions.NoSuchDbException;

/**
 * Created by RENT on 2016-06-11.
 */
public abstract class DAOFactory {

    private static final int POSTGRESQL_DAO_FACTORY = 1;

    public abstract UserDAO getUserDAO();

    public abstract BookDAO getBookDAO();

    public abstract PenaltyDAO getPenaltyDAO();

    public abstract RentalDAO getRentalDAO();

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
