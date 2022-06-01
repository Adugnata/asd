package bank.domain;

import java.util.*;

import bank.service.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account extends Subject {
    long accountNumber;
    Collection<AccountEntry> entries = new ArrayList<AccountEntry>();
    Customer customer;

    public Account(long accountnr) {
        this.accountNumber = accountnr;
    }

    public double getBalance() {
        return entries.stream().mapToDouble(AccountEntry::getAmount).sum();
    }

    public void deposit(double amount) {
        entries.add(new AccountEntry(new Date(), amount, "deposit", "", ""));
        NotifyObserver(this);

    }

    public void withdraw(double amount) {
        entries.add(new AccountEntry(new Date(), -amount, "withdraw", "", ""));
        NotifyObserver(this);
    }

    private void addEntry(AccountEntry entry) {
        entries.add(entry);
    }

    public void transferFunds(Account toAccount, double amount, String description) {
        entries.add(new AccountEntry(new Date(), -amount, description, "" + toAccount.getAccountNumber(), toAccount.getCustomer().getName()));
        toAccount.addEntry(new AccountEntry(new Date(), amount, description, "" + toAccount.getAccountNumber(), toAccount.getCustomer().getName()));
        NotifyObserver(this);
        NotifyObserver(toAccount);

    }
}
