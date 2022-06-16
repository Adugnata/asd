package bank.service;

import bank.dao.AccountDAO;
import bank.dao.AccountDAOImpl;
import bank.domain.Account;
import bank.domain.Customer;
import email.EmailSender;
import logging.Logger;
import sms.SMSSender;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO;
    private ArrayList<Observer> observers = new ArrayList<>();
    public AccountServiceImpl() {
        accountDAO = new AccountDAOImpl();
        observers.addAll(List.of(new Logger(),new EmailSender(),new SMSSender()));
    }

    public Account createAccount(long accountNumber, String customerName) {
        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);
        observers.forEach(account::addObserver);
        account.NotifyObserver(account);

        accountDAO.saveAccount(account);
        return account;
    }

    public void deposit(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        accountDAO.updateAccount(account);
    }

    public Account getAccount(long accountNumber) {
        return accountDAO.loadAccount(accountNumber);
    }

    public Collection<Account> getAllAccounts() {
        return accountDAO.getAccounts();
    }

    public void withdraw(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
    }

    public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);
    }
}
