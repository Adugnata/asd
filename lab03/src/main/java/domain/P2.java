package domain;

public class P2 extends InterestPromotionDecorator {
    public P2(InterestStrategy interestStrategy) {
        super(interestStrategy);
    }

    @Override
    public double AddInterest(double balance) {
        return interestStrategy.AddInterest(balance) * 1.02 + balance * 0.02;
    }
    @Override
    public String toString() {
        return "domain.P2 + " + interestStrategy.toString();
    }


}
