package domain;

public class P1 extends InterestPromotionDecorator {
    public P1(InterestStrategy interestStrategy) {
        super(interestStrategy);
    }

    @Override
    public double AddInterest(double balance) {
        return interestStrategy.AddInterest(balance) * 1.01 + balance * 0.01;
    }

    @Override
    public String toString() {
        return "domain.P1 + " + interestStrategy.toString();
    }
}
