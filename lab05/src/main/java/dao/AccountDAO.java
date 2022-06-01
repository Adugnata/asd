package dao;

import domain.Account;

import java.util.*;


public class AccountDAO implements IAccountDAO {
	Collection<Account> accounts = new ArrayList<Account>();

	public void saveAccount(Account account) {
		accounts.add(account); // add the new
	}

	public void updateAccount(Account account) {
		Optional.ofNullable(loadAccount(account.getAccountnumber())).ifPresent(
				acc->{
					accounts.remove(acc); // remove the old
					accounts.add(account); // add the new
				}
		);
	}

	public Account loadAccount(long accountnumber) {
	return 	accounts.stream()
			.filter(account->account.getAccountnumber()==accountnumber)
			.findFirst()
			.orElse(null);
	}

	public Collection<Account> getAccounts() {
		return accounts;
	}

}
