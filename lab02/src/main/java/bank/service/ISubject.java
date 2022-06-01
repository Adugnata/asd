package bank.service;

import bank.domain.Account;

public interface ISubject {
	void addObserver(Observer observer);
	void NotifyObserver(Account account);
}