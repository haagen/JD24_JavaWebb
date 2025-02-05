package se.grit.gritcrm.dao;

import se.grit.gritcrm.model.Account;

public class AccountDAO extends GenericDAO<Account, Integer>{

    public AccountDAO() {
        super(Account.class);
    }

}
