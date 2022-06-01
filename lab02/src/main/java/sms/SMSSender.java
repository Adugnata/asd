package sms;

import java.util.Date;
import bank.domain.Account;
import bank.service.Observer;

public class SMSSender implements Observer {
	public void sendSMS(String message) {
		System.out.println("Sending SMS => " + new Date() + ", " + message);
	}
	public void update(Account account) {
		sendSMS(new StringBuilder()
				.append("Account ")
				.append(account.getAccountNumber())
				.append(" is changed, new balance = ")
				.append(account.getBalance())
				.toString());

	}

}

