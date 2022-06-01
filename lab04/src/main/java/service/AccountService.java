package service;

import domain.Account;
import domain.Customer;
import factory.FactoryProducer;
import factory.FactoryType;
import lombok.Getter;
import repository.IAccountDAO;

import java.util.Collection;

@Getter
public class AccountService implements IAccountService {
    private IAccountDAO iAccountDAO;

    public AccountService(FactoryType factory) {
        iAccountDAO = FactoryProducer.getFactory(factory).build();
    }

    public Account createAccount(long accountNumber, String customerName) {
        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);
        iAccountDAO.saveAccount(account);
        return account;
    }

    public void deposit(long accountNumber, double amount) {
        Account account = iAccountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        iAccountDAO.updateAccount(account);
    }

    public Account getAccount(long accountNumber) {
        return iAccountDAO.loadAccount(accountNumber);
    }

    public Collection<Account> getAllAccounts() {
        return iAccountDAO.getAccounts();
    }

    public void withdraw(long accountNumber, double amount) {
        Account account = iAccountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        iAccountDAO.updateAccount(account);
    }


    public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
        Account fromAccount = iAccountDAO.loadAccount(fromAccountNumber);
        Account toAccount = iAccountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        iAccountDAO.updateAccount(fromAccount);
        iAccountDAO.updateAccount(toAccount);
    }
}
