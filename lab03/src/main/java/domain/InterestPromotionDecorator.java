package domain;

public abstract class InterestPromotionDecorator implements InterestStrategy {
    protected InterestStrategy interestStrategy;

    public InterestPromotionDecorator(InterestStrategy interestStrategy) {
        this.interestStrategy = interestStrategy;
    }

    @Override
    public double AddInterest(double balance) {
        return interestStrategy.AddInterest(balance);
    }
}
