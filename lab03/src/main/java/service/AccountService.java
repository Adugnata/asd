package service;

import domain.Account;
import domain.InterestStrategy;

import java.util.Collection;

public interface AccountService {
    Account createAccount(String accountNumber, String customerName, InterestStrategy interestStrategy);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
    void addInterest(String accountNumber);
}
