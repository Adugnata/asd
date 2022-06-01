package domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	private long accountNumber;
	private String type;
	private Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();
	private Customer customer;
	protected InterestStrategy interestStrategy;

	public Account (long accountnr){
		this.accountNumber = accountnr;
	}
	public double getBalance() {
		return entryList.stream().mapToDouble(AccountEntry::getAmount).sum();
	}
	public void deposit(double amount){
		entryList.add(new AccountEntry(new Date(), amount, "deposit", "", ""));
	}
	public void withdraw(double amount){
		entryList.add(new AccountEntry(new Date(), -amount, "withdraw", "", ""));
	}

	private void addEntry(AccountEntry entry){
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description){
		AccountEntry fromEntry = new AccountEntry(new Date(), -amount, description, ""+toAccount.getAccountNumber(), toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(new Date(), amount, description, ""+toAccount.getAccountNumber(), toAccount.getCustomer().getName());
		entryList.add(fromEntry);	
		toAccount.addEntry(toEntry);
	}

	public void addInterest(){
		entryList.add(new AccountEntry(new Date(), interestStrategy.addInterest(getBalance()), "interest", "", ""));
	}
}
