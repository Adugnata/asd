package repository;

import java.util.Collection;
import domain.Account;

public interface IAccountDAO {
	void saveAccount(Account account);
	void updateAccount(Account account);
	Account loadAccount(long accountNumber);
	Collection<Account> getAccounts();
}
