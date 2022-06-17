package framework.strategy;

import common.domain.Account;
import framework.ui.pages.GenerateReport;

public interface ReportStrategy {
    void generateReport(Account account, GenerateReport generateReport);
}
