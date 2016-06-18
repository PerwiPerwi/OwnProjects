package services;

import controllers.SeciurityController;
import dao.ContactDAO;
import dao.DAOFactory;
import models.Contact;
import models.User;
import java.util.List;

/**
 * Created by RENT on 2016-06-16.
 */
public class ContactService {

    public List<Contact> findContactListByUserId(long userId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        ContactDAO contactDAO = factory.getContactDAO();
        return contactDAO.findContactListByUserId(userId);
    }
    public Contact findContactByContactIdAndUserId(long contactId, long userId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        ContactDAO contactDAO = factory.getContactDAO();
        return contactDAO.findContactByContactIdAndUserId(contactId, userId);
    }
    public Contact findContactByContactId(long contactId){
        DAOFactory factory = DAOFactory.getDAOFactory();
        ContactDAO contactDAO = factory.getContactDAO();
        return contactDAO.findById(contactId);
    }
    public boolean deleteContactById(long contactId){
        DAOFactory factory = DAOFactory.getDAOFactory();
        ContactDAO contactDAO = factory.getContactDAO();
        return contactDAO.delete(contactId);
    }

    public void update(Contact contact){
        DAOFactory factory = DAOFactory.getDAOFactory();
        ContactDAO contactDAO = factory.getContactDAO();
        firstUpperLetter(contact);
        contactDAO.update(contact);
    }

    public void firstUpperLetter(Contact contact) {

        String name = contact.getContactName();
        contact.setContactName(name.substring(0, 1).toUpperCase() + name.substring(1));

        String email = contact.getContactData().getEmail();
        contact.getContactData().setEmail(email.substring(0, 1).toUpperCase() + email.substring(1));

        String country = contact.getContactData().getCountry();
        contact.getContactData().setCountry(country.substring(0, 1).toUpperCase() + country.substring(1));

        String city = contact.getContactData().getCity();
        contact.getContactData().setCity(city.substring(0, 1).toUpperCase() + city.substring(1));

        String street = contact.getContactData().getStreet();
        contact.getContactData().setStreet(street.substring(0, 1).toUpperCase() + street.substring(1));

    }
}
