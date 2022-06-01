package dao;

import domain.Account;

import java.util.*;

public class AccountDAOImpl implements AccountDAO {
	Collection<Account> accountlist = new ArrayList<Account>();

	public void saveAccount(Account account) {
		accountlist.add(account); // add the new
	}

	public void updateAccount(Account account) {
		Account accountexist = loadAccount(account.getAccountNumber());
		if (accountexist != null) {
			accountlist.remove(accountexist); // remove the old
			accountlist.add(account); // add the new
		}

	}

	public Account loadAccount(long accountNumber) {
		for (Account account : accountlist) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		return null;
	}

	public Collection<Account> getAccounts() {
		return accountlist;
	}

}
