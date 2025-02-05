package se.grit.gritcrm.dao;

import se.grit.gritcrm.model.Contact;

public class ContactDAO extends GenericDAO<Contact, Integer> {

    public ContactDAO() {
        super(Contact.class);
    }
}
