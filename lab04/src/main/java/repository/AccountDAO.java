package repository;

import java.util.*;

import domain.Account;

public class AccountDAO implements IAccountDAO {
	Collection<Account> accounts = new ArrayList<Account>();

	public void saveAccount(Account account) {
		if(!accounts.contains(account))
			accounts.add(account); // add the new
	}

	public void updateAccount(Account account) {
		Optional.ofNullable(loadAccount(account.getAccountNumber()))
				.ifPresent(acc->{
					accounts.remove(acc);
					accounts.add(account);
				});
	}

	public Account loadAccount(long accountNumber) {
		return accounts.stream()
				.filter(account -> Objects.equals(account.getAccountNumber(), accountNumber))
				.findFirst()
				.orElse(null);
	}

	public Collection<Account> getAccounts() {
		return accounts;
	}

}
