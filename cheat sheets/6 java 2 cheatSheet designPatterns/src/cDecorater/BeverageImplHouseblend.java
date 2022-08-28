package cDecorater;

//regular classes
public class BeverageImplHouseblend extends BeverageAbstract {

	public BeverageImplHouseblend() {
		description = "house blend coffee";
	}

	@Override
	public double cost() {
		return 0.89;
	}

}
