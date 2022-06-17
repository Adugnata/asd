package common.dto;

import framework.ui.IUIInvoker;

public class AccountDTOCreator {
    public static AccountDTO create(IUIInvoker iuiInvoker) {
        return new AccountDTO(iuiInvoker.getAccountNumber(), iuiInvoker.getAccountType(), iuiInvoker.getCustomer());
    }
}
