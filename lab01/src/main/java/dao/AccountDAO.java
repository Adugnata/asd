package dao;

import java.util.Collection;
import domain.Account;

public interface AccountDAO {
	void saveAccount(Account account);
	void updateAccount(Account account);
	Account loadAccount(long accountNumber);
	Collection<Account> getAccounts();
}
