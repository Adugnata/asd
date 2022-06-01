package command;


import service.IAccountService;

public class TransferFundsCommand implements ICommand {
    private IAccountService accountService;
    private long fromaccountnumber;
    private long toaccountnumber;
    private double amount;
    private String description;

    public TransferFundsCommand(IAccountService accountService, long fromaccountnumber, long toaccountnumber, double amount, String description) {
        this.accountService = accountService;
        this.fromaccountnumber = fromaccountnumber;
        this.toaccountnumber = toaccountnumber;
        this.amount = amount;
        this.description = description;
    }
    public void execute() {
        accountService.transferFunds(fromaccountnumber, toaccountnumber, amount, description);

    }
    public void undo() {
        accountService.transferFunds(toaccountnumber, fromaccountnumber, amount, "undo:" + description);

    }

}
