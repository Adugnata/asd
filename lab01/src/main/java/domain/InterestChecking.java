package domain;

public class InterestChecking implements InterestStrategy {

	public double addInterest(double balance) {
		return (balance > 1000) ? balance * 0.025 : balance * 0.015;
	}
}