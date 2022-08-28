package fFactoryAbstract;

public class CNYPizzaIngredientFactory implements BPizzaIngredientFactory {

	@Override
	public ACDough createDough() {
		return new ACeeThinCrustDough();
	}
	
	@Override
	public AESauce createSauce() {
		return new AEttMarinaraSauce();
	}
	
	@Override
	public AACheese createCheese() {
		return new AAddReggianoCheese();
	}
		
	@Override
	public AFVeggies[] createVeggies() {
		AFVeggies veggies[] = { new AFzzGarlic(), new AFzzOnion(), new AFzzMushroom(), new AFzzRedPepper() };
		return veggies;
	}
		
	@Override
	public ADPepperoni createPepperoni() {
		return new ADrrSlicedPepperoni();
	}
	
	@Override
	public ABClams createClam() {
		return new ABddFreshClams();
	}

}
