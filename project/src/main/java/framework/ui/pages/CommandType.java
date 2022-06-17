package framework.ui.pages;

public enum CommandType {
    ADDINTEREST(" ADDINTEREST"),
    ADDCOMPANYACCT(" ADDCOMPANYACCT"),
    REPORT("REPORT"),
    DEPOSIT("REPORT"),
    WITHDRAW("WITHDRAW"),
    ADDPERSONALACCT("ADDPERSONALACCT");

    private final String name;

    CommandType(String name) {
        this.name = name;
    }
}
