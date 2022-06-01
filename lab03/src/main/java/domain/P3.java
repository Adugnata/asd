package domain;

public class P3 extends InterestPromotionDecorator {
    public P3(InterestStrategy interestStrategy) {
        super(interestStrategy);
    }

    @Override
    public double AddInterest(double balance) {
        return interestStrategy.AddInterest(balance) * 1.03 + balance * 0.03;
    }

    @Override
    public String toString() {
        return "domain.P3 + " + interestStrategy.toString();
    }

}
