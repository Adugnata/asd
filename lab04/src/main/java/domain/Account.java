package domain;

import java.util.*;


public class Account {
	long accountNumber;
	Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();
	Customer customer;
	public Account (long accountnr){
		this.accountNumber = accountnr;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
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
		toAccount.deposit(amount);
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

}
