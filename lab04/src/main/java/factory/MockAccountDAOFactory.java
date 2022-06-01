package factory;

import repository.IAccountDAO;
import repository.MockAccountDAO;

public class MockAccountDAOFactory extends AbstractFactory{
    public IAccountDAO build() {
       return new MockAccountDAO();
    }
}
