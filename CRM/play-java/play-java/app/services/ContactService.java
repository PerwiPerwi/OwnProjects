package services;

import dao.ContactDAO;
import dao.DAOFactory;
import models.Contact;

import java.util.List;


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

    public Contact findContactByContactId(long contactId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        ContactDAO contactDAO = factory.getContactDAO();
        return contactDAO.findById(contactId);
    }

    public boolean deleteContactById(long contactId) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        ContactDAO contactDAO = factory.getContactDAO();
        return contactDAO.delete(contactId);
    }

    public void update(Contact contactForUpdate, Contact oldContact) {
        DAOFactory factory = DAOFactory.getDAOFactory();
        ContactDAO contactDAO = factory.getContactDAO();
        firstUpperLetter(oldContact);
        contactDAO.update(contactForUpdate, oldContact);
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
