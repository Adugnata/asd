package banking;

import banking.commands.*;
import banking.strategy.BankingUIStrategy;
import framework.command.Command;
import framework.ui.IUIInvoker;
import framework.ui.pages.CommandType;
import framework.ui.pages.UIFrameInvoker;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Driver {
    private final Map<String, Command> commands;

    public Driver() {
        this.commands = new HashMap<>();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            IUIInvoker iuiInvoker = UIFrameInvoker.getInstance();
            iuiInvoker.setCommands(new Driver().getCommands());
            iuiInvoker.initialize("Banking Application", new BankingUIStrategy());

            //Create a new instance of our application's frame, and make it visible.
            iuiInvoker.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    public Map<String, Command> getCommands() {
        commands.put(CommandType.ADDINTEREST.name(), new AddInterestCommand());
        commands.put(CommandType.ADDPERSONALACCT.name(), new AddPersonalAccountCommand());
        commands.put(CommandType.ADDCOMPANYACCT.name(), new AddCompanyAccountCommand());
        commands.put(CommandType.DEPOSIT.name(), new DepositCommand());
        commands.put(CommandType.WITHDRAW.name(), new WithdrawCommand());
        commands.put(CommandType.REPORT.name(), new ReportCommand());
        return commands;
    }
}
