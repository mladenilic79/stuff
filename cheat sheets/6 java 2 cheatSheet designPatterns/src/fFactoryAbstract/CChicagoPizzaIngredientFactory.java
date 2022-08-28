package fFactoryAbstract;

public class CChicagoPizzaIngredientFactory implements BPizzaIngredientFactory {

	@Override
	public ACDough createDough() {
		return new ACeeThickCrustDough();
	}
	
	@Override
	public AESauce createSauce() {
		return new AEttPlumTomatoSauce();
	}
	
	@Override
	public AACheese createCheese() {
		return new AAddMozzarellaCheese();
	}
	
	@Override
	public AFVeggies[] createVeggies() {
		AFVeggies veggies[] = { new AFzzBlackOlives(), new AFzzSpinach(), new AFzzEggplant() };
		return veggies;
	}
	
	@Override
	public ADPepperoni createPepperoni() {
		return new ADrrSlicedPepperoni();
	}
	
	@Override
	public ABClams createClam() {
		return new ABddFrozenClams();
	}
	
}
