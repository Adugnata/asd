package dao;

import domain.Account;

import java.util.Collection;

public interface AccountDAO {
    void saveAccount(Account account);
    void updateAccount(Account account);
    Account loadAccount(String accountNumber);
    Collection<Account> getAccounts();
}
