package domain;

public class InterestChecking implements InterestStrategy {
    @Override
    public double AddInterest(double balance) {
        return (balance > 1000) ? balance * 0.025 : balance * 0.015;
    }

    @Override
    public String toString() {
        return "CheckingAccount";
    }
}
