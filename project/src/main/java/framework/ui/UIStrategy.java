package framework.ui;

import common.domain.Account;

import java.util.Collection;

public interface UIStrategy {
    Collection<String> getAccountTypes();

    Collection<String> getReportColumnNames();

    int getIdColumnIndex();

    Object[] buildRow(Account account);

    boolean hasReport();
}