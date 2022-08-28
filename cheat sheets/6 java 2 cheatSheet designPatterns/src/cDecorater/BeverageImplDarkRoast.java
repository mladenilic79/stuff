package cDecorater;

// regular classes
public class BeverageImplDarkRoast extends BeverageAbstract {

	public BeverageImplDarkRoast() {
		description = "dark roast";
	}

	@Override
	public double cost() {
		return 1.09;
	}

}
