package controllers;


import models.Contact;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import services.ContactService;
import views.html.Contacts.addContactForm;
import views.html.Contacts.contactList;
import views.html.Contacts.editContactForm;


import javax.inject.Inject;
import java.util.List;

public class ContactsController extends Controller {

    @Inject
    FormFactory formFactory;

    ContactService contactService = new ContactService();

    @Security.Authenticated(SeciurityController.class)
    public Result addContactForm() {
        Form<Contact> contactForm = formFactory.form(Contact.class);
        return ok(addContactForm.render(contactForm));
    }

    @Security.Authenticated(SeciurityController.class)
    public Result addContact() {
        if (SeciurityController.getUser() == null) {
            return redirect(routes.LoginAndLogoutController.loginForm());
        }

        Form<Contact> contactForm = formFactory.form(Contact.class).bindFromRequest();
        if (contactForm.hasErrors()) {
            return badRequest(addContactForm.render(contactForm));
        }

        Contact contact = contactForm.get();
        contactService.firstUpperLetter(contact);
        contact.getContactData().insert();
        contact.setUser(SeciurityController.getUser());
        contact.setContactData(contact.getContactData());
        contact.insert();
        return redirect(routes.ContactsController.getContacts());
    }

    @Security.Authenticated(SeciurityController.class)
    public Result getContacts() {
        if (SeciurityController.getUser() == null) {
            return redirect(routes.LoginAndLogoutController.loginForm());
        }
        User user = SeciurityController.getUser();
        List<Contact> contactsList = contactService.findContactListByUserId(user.getId());
        return ok(contactList.render(contactsList, user));
    }

    @Security.Authenticated(SeciurityController.class)
    public Result editContactForm(long contactId) {
        if (SeciurityController.getUser() == null) {
            return redirect(routes.LoginAndLogoutController.loginForm());
        }
        User user = SeciurityController.getUser();
        Contact contact = contactService.findContactByContactIdAndUserId(contactId, user.getId());

        Form<Contact> contactForm = formFactory.form(Contact.class).fill(contact);

        if (contact == null) {
            return notFound();
        }
        return ok(editContactForm.render(contactForm));
    }

    @Security.Authenticated(SeciurityController.class)
    public Result editContact(long contactId) {
        if (SeciurityController.getUser() == null) {
            return redirect(routes.LoginAndLogoutController.loginForm());
        }
        Form<Contact> contactForm = formFactory.form(Contact.class).bindFromRequest();
        if (contactForm.hasErrors()) {
            return badRequest(addContactForm.render(contactForm));
        }

        User user = SeciurityController.getUser();
        Contact contactDb = contactService.findContactByContactIdAndUserId(contactId, user.getId());

        if (contactDb == null) {
            return notFound();
        }

        Contact contact = contactForm.get();
        contactService.firstUpperLetter(contact);
        contact.getContactData().setId(contactDb.getContactData().getId());
        contact.getContactData().update();
        contact.setUser(SeciurityController.getUser());
        contact.setContactData(contact.getContactData());
        contact.update();
        return redirect(routes.ContactsController.getContacts());
    }

    @Security.Authenticated(SeciurityController.class)
    public Result deleteContact(long contactId) {
        if (SeciurityController.getUser() == null) {
            return redirect(routes.LoginAndLogoutController.loginForm());
        }
        if(contactService.deleteContactById(contactId)){
            return redirect(routes.ContactsController.getContacts());
        }
        return badRequest();
    }
}
