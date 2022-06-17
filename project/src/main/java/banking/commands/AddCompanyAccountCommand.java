package banking.commands;

import banking.service.BankAccountServiceImpl;
import common.dto.AccountDTOCreator;
import framework.command.Command;
import framework.ui.IUIInvoker;

public class AddCompanyAccountCommand implements Command {
    public void execute(IUIInvoker iuiInvoker) {
        BankAccountServiceImpl
                .getInstance()
                .createAccount(AccountDTOCreator.create(iuiInvoker));
    }
}