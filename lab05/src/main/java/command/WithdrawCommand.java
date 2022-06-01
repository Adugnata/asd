package command;


import service.IAccountService;

public class WithdrawCommand implements ICommand{
	private IAccountService accountService;
	private long accountNumber;
	private double amount;
	
	public WithdrawCommand(IAccountService accountService,long accountnumber, double amount) {
		this.accountService=accountService;
		this.accountNumber =accountnumber;
		this.amount=amount;
	}

	public void execute() {
		accountService.withdraw(accountNumber, amount);
	}

	public void undo() {
		accountService.deposit(accountNumber, amount);
	}

}
