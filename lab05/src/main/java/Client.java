import java.util.Collection;

import command.DepositCommand;
import command.Log;
import command.TransferFundsCommand;
import command.WithdrawCommand;
import domain.Account;
import domain.AccountEntry;
import domain.Customer;
import service.*;


public class Client {
	public static void main(String[] args) {
		//create HistoryList
		Log log = new Log();
		
		IAccountService accountService = new AccountService();
		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");
		//use account 1;
		DepositCommand depositCommand1 = new DepositCommand(accountService,1263862, 240);
		depositCommand1.execute();
		log.addCommand(depositCommand1);

		DepositCommand depositCommand2 = new DepositCommand(accountService,1263862, 529);
		depositCommand2.execute();
		log.addCommand(depositCommand2);

		WithdrawCommand withdrawCommand1 = new WithdrawCommand(accountService,1263862, 529);
		withdrawCommand1.execute();
		log.addCommand(withdrawCommand1);

		//use account 2;
		DepositCommand depositCommand3 = new DepositCommand(accountService,4253892, 12450);
		depositCommand3.execute();
		log.addCommand(depositCommand3);

		TransferFundsCommand transferFundsCommand1 = new TransferFundsCommand(accountService,4253892, 1263862, 100, "payment of invoice 10232");
		transferFundsCommand1.execute();
		log.addCommand(transferFundsCommand1);
		//undo
		log.undo();
		
		// show balances		
		Collection<Account> accountlist = accountService.getAllAccounts();
		Customer customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("-Date-------------------------"
							+ "-Description------------------"
							+ "-Amount-------------");
			for (AccountEntry entry : account.getEntries()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate()
						.toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					+ "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
					account.getBalance());
		}
	}

}


