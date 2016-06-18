package dao;

import models.Contact;
import models.ContactData;

import java.util.List;

/**
 * Created by RENT on 2016-06-15.
 */
public interface ContactDAO extends GenericDAO<Contact, Long> {
    List<Contact> findContactListByUserId(long userId);
    Contact findContactByContactIdAndUserId(long contactId, long userId);
    void createContactData(ContactData contactData);
}
