package bank.dao;

import java.util.*;

import bank.domain.Account;

public class AccountDAOImpl implements AccountDAO {
    Collection<Account> accounts = new ArrayList<Account>();

    public void saveAccount(Account account) {
        if (!accounts.contains(account))
            accounts.add(account); // add the new
    }

    public void updateAccount(Account account) {
        Optional.ofNullable(loadAccount(account.getAccountNumber()))
                .ifPresent(acct -> {
                    accounts.remove(acct);// remove the old
                    accounts.add(account); // add the new
                });
    }

    public Account loadAccount(long accountNumber) {
        return accounts.stream()
                .filter(account -> account.getAccountNumber() == accountNumber)
                .findFirst()
                .orElse(null);
    }

    public Collection<Account> getAccounts() {
        return accounts;
    }
}
