package headfirst.designpatterns.decorator.starbuzz;

public abstract class CondimentDecorator extends Beverage {
	Beverage beverage;
	public CondimentDecorator(Beverage beverage) {
		super();
		this.beverage = beverage;
	}
	public abstract String getDescription();
}
