package cDecorater;

public class CondimentDecoraterImplSoy extends CondimentDecoraterAbstract {

	// this can be also in DecoraterAbstract class
	// link to beverage we are wrapping
	//	BeverageAbstract beverage;
	
	// & a way to set that beverage, here with constructor
	public CondimentDecoraterImplSoy(BeverageAbstract beverage) {
		this.beverage = beverage;
	}

	// append description to beverage description
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", soy";
	}

	// append cost
	@Override
	public double cost() {
		return 0.10 + beverage.cost();
	}

}
