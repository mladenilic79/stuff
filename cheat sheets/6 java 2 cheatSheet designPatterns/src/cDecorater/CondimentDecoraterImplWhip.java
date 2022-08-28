package cDecorater;

public class CondimentDecoraterImplWhip extends CondimentDecoraterAbstract {

	// this can be also in DecoraterAbstract class
	// link to beverage we are wrapping
	//	BeverageAbstract beverage;
	
	// & a way to set that beverage, here with constructor
	public CondimentDecoraterImplWhip(BeverageAbstract beverage) {
		this.beverage = beverage;
	}

	// append description to beverage description
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", whip";
	}

	// append cost
	@Override
	public double cost() {
		return 0.15 + beverage.cost();
	}

}
