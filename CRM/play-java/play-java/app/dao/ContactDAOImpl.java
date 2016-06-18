package dao;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Finder;
import models.Contact;
import models.ContactData;

import java.util.List;

/**
 * Created by RENT on 2016-06-13.
 */
public class ContactDAOImpl implements ContactDAO {

    public Finder<Long, Contact> contactFinder = new Finder<Long, Contact>(Contact.class);

    @Override
    public List<Contact> findContactListByUserId(long userId) {
        return Ebean.find(Contact.class).where().eq("user.id", userId).orderBy("id asc").findList();
    }

    @Override
    public Contact findContactByContactIdAndUserId(long contactId, long userId) {
        return Ebean.find(Contact.class).where().eq("user.id", userId).idEq(contactId).findUnique();
    }

    @Override
    public void createContactData(ContactData contactData) {
        Ebean.insert(contactData);
    }

    @Override
    public void create(Contact contact) {
        Ebean.insert(contact);
    }

    @Override
    public Contact findById(Long contactId) {
        return Ebean.find(Contact.class).where().eq("id", contactId).idEq(contactId).findUnique();
    }

    @Override
    public boolean delete(Long contactId) {
        Contact contactForDelete = findById(contactId);
        return Ebean.delete(contactForDelete);
    }

    @Override
    public void update(Contact contact) {
        Ebean.update(contact);
    }
}
