package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Customer customer;
    private String accountNumber;
    private InterestStrategy interestStrategy;
    private String accountTypeName;

    private List<AccountEntry> entryList = new ArrayList<AccountEntry>();

    public Account(String accountNumber, InterestStrategy interestStrategy) {
        this.accountNumber = accountNumber;
        this.interestStrategy = interestStrategy;
        accountTypeName = this.interestStrategy.toString();
    }

    public double getBalance() {
        return entryList.stream().mapToDouble(AccountEntry::getAmount).sum();
    }

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
        entryList.add(entry);
    }

    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
        entryList.add(entry);
    }

    private void addEntry(AccountEntry entry) {
        entryList.add(entry);
    }

    public void transferFunds(Account toAccount, double amount, String description) {
        entryList.add(new AccountEntry(-amount, description, toAccount.getAccountNumber(),
                toAccount.getCustomer().getName()));
        toAccount.addEntry(new AccountEntry(amount, description, toAccount.getAccountNumber(),
                toAccount.getCustomer().getName()));
    }

}
