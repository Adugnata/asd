package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	long accountnumber;
	Collection<AccountEntry> entries = new ArrayList<AccountEntry>();
	Customer customer;

	
	public Account (long accountnr){
		this.accountnumber = accountnr;
	}
	public double getBalance() {
		return entries.stream().mapToDouble(AccountEntry::getAmount).sum();
	}
	public void deposit(double amount){
		entries.add(new AccountEntry(new Date(), amount, "deposit", "", ""));
	}
	public void withdraw(double amount){
		entries.add(new AccountEntry(new Date(), -amount, "withdraw", "", ""));
	}

	private void addEntry(AccountEntry entry){
		entries.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description){
		AccountEntry fromEntry = new AccountEntry(new Date(), -amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(new Date(), amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
		entries.add(fromEntry);
		toAccount.addEntry(toEntry);
	}
}
