package cDecorater;

//regular classes
public class BeverageImplEspresso extends BeverageAbstract {

	public BeverageImplEspresso() {
		description = "expresso";
	}

	@Override
	public double cost() {
		return 0.99;
	}

}
