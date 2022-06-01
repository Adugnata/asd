package bank.service;

import java.util.ArrayList;
import java.util.Collection;

import bank.domain.Account;

public class Subject implements ISubject {
    private final Collection<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        if (!observers.contains(observer))
            observers.add(observer);
    }

    public void NotifyObserver(Account account) {
        observers.forEach(observer -> observer.update(account));
    }
}
