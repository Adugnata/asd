package factory;

import repository.IAccountDAO;

public abstract class AbstractFactory {
    public abstract IAccountDAO build();
}
