package factory;

public class FactoryProducer {
    public static AbstractFactory getFactory(FactoryType factory) {
        AbstractFactory abstractFactory = null;
        switch (factory){
            case AccountDAOFactory1 -> abstractFactory = new AccountDAOFactory();
            case AccountDAOFactory2 -> abstractFactory = new MockAccountDAOFactory();
            default -> {}
        }
        return abstractFactory;
    }
}
