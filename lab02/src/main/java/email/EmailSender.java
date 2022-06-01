package email;

import java.util.Date;
import bank.domain.Account;
import bank.service.Observer;

public class EmailSender implements Observer {
	public void sendEmail(String message) {
		System.out.println("Sending email => " + new Date() + ", " + message);
	}
	public void update(Account account) {
		if (account.getBalance() == 0.0) sendEmail("Account " + account.getAccountNumber() + " is created ");
	}
}
