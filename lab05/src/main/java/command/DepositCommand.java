package command;


import service.IAccountService;

public class DepositCommand implements ICommand{
	private IAccountService accountService;
	private long accountNumber;
	private double amount;
	
	public DepositCommand(IAccountService accountService,long accountNumber, double amount) {
		this.accountService=accountService;
		this.accountNumber =accountNumber;
		this.amount=amount;
	}

	public void execute() {
		accountService.deposit(accountNumber, amount);
		
	}

	public void undo() {
		accountService.withdraw(accountNumber, amount);
	}

}
