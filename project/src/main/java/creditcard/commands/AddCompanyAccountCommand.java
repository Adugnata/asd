package creditcard.commands;

import common.dto.AccountDTO;
import common.dto.AccountDTOCreator;
import creditcard.service.CreditCardAccountServiceImpl;
import framework.command.Command;
import framework.ui.IUIInvoker;

public class AddCompanyAccountCommand implements Command {

    public void execute(IUIInvoker iuiInvoker) {
        AccountDTO accountDTO = AccountDTOCreator.create(iuiInvoker);
        CreditCardAccountServiceImpl.getInstance()
                .createAccount(accountDTO);
    }
}
