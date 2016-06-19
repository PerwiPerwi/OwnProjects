package dao;

/**
 * Created by RENT on 2016-06-11.
 */
public class PostgreSQLDAOFactory extends DAOFactory {
    @Override
   public UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    @Override
    public BookDAO getBookDAO() {
        return new BookDAOImpl();
    }

    @Override
    public PenaltyDAO getPenaltyDAO() {
        return new PenaltyDAOImpl();
    }

    @Override
    public RentalDAO getRentalDAO() {
        return new RentalDAOImpl();
    }
}
