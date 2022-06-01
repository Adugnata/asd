package factory;

import repository.AccountDAO;
import repository.IAccountDAO;

public class AccountDAOFactory extends AbstractFactory{
    public IAccountDAO build() {
             return new AccountDAO();
    }
}
