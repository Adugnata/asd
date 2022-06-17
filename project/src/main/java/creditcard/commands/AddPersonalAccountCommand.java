package creditcard.commands;

import common.dto.AccountDTOCreator;
import creditcard.service.CreditCardAccountServiceImpl;
import framework.command.Command;
import framework.ui.IUIInvoker;

public class AddPersonalAccountCommand implements Command {
    @Override
    public void execute(IUIInvoker iuiInvoker) {
        CreditCardAccountServiceImpl
                .getInstance()
                .createAccount(AccountDTOCreator.create(iuiInvoker));
    }
}
