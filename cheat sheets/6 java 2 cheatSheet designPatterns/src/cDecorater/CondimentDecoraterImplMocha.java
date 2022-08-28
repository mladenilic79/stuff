package cDecorater;

public class CondimentDecoraterImplMocha extends CondimentDecoraterAbstract {

	// this can be also in DecoraterAbstract class
	// link to beverage we are wrapping/decorating
	//	BeverageAbstract beverage;
	
	// a way to set that beverage, here with constructor
	public CondimentDecoraterImplMocha(BeverageAbstract beverage) {
		this.beverage = beverage;
	}

	// append description to beverage description
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", mocha";
	}
	
	// append cost
	@Override
	public double cost() {
		return 0.20 + beverage.cost();
	}

}
