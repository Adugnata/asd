package service;

import java.util.Collection;
import domain.Account;

public interface AccountService {
    Account createAccount(String type, long accountNumber, String customerName);
    Account getAccount(long accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (long accountNumber, double amount);
    void withdraw (long accountNumber, double amount);
    void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description);
    void addInterest();
}
