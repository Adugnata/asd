package logging;

import java.util.Date;
import bank.domain.Account;
import bank.service.*;

public class Logger implements Observer {


	public void log(String message) {
		System.out.println("log => " + new Date() + ", " + message);
	}

	public void update(Account account) {
		log(new StringBuilder()
				.append("Account ")
				.append(account.getAccountNumber())
				.append(" is changed, new balance = ")
				.append(account.getBalance())
				.toString());

	}

}
