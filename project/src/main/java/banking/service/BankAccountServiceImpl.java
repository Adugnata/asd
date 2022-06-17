package banking.service;

import banking.constant.BankingAccountType;
import banking.dao.BankingAccountDAOImpl;
import banking.domain.CheckingAccount;
import banking.domain.SavingsAccount;
import banking.strategy.*;
import common.domain.Account;
import common.domain.Customer;
import common.dto.AccountDTO;
import common.service.AccountService;
import common.utils.ApplicationMessageConstant;
import framework.domain.CompanyCustomer;
import framework.domain.IndividualCustomer;
import framework.observer.EmailSender;
import framework.ui.pages.GenerateReport;

public class BankAccountServiceImpl extends AccountService {
    private static volatile BankAccountServiceImpl instance;

    private BankAccountServiceImpl() {
        super(BankingAccountDAOImpl.getInstance());
        setPersonalAccountTransferAlertBalance(500);
        this.registerObserver(new EmailSender(this));
    }

    public static BankAccountServiceImpl getInstance() {
        if (instance == null)
            synchronized (BankAccountServiceImpl.class) {
                if (instance == null)
                    instance = new BankAccountServiceImpl();
            }
        return instance;
    }

    public static void createReport(String accountNumber, GenerateReport generateReport) {
        Account account = instance.getAccount(accountNumber);
        instance.generateReport(account, generateReport, new BankReportStrategy());
    }

    @Override
    public Account createAccountFactory(AccountDTO accountDTO) throws UnsupportedOperationException {
        Customer customer = accountDTO.getCustomer();
        BankingAccountType bankAccountType = BankingAccountType.valueOf(accountDTO.getAccountType());
        return getConcreteAccountObject(customer, bankAccountType);
    }

    private Account getConcreteAccountObject(Customer customer, BankingAccountType bankAccountType) throws UnsupportedOperationException {
        if (customer instanceof IndividualCustomer)
            return (bankAccountType == BankingAccountType.CHECKING)
                    ? new CheckingAccount(new PersonalCheckingAccInterestStrategy())
                    : new SavingsAccount(new PersonalSavingsAccInterestStrategy());
        else if (customer instanceof CompanyCustomer)
            return (bankAccountType == BankingAccountType.CHECKING)
                    ? new CheckingAccount(new CompanyCheckingAccInterestStrategy())
                    : new SavingsAccount(new CompanySavingAccInterestStrategy());

        throw new UnsupportedOperationException(ApplicationMessageConstant.INVALID_ACCOUNT_TYPE.name);
    }

}