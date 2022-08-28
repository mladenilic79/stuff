package fFactoryAbstract;

public interface BPizzaIngredientFactory {
	
	public ACDough createDough();
	public AESauce createSauce();
	public AACheese createCheese();
	public AFVeggies[] createVeggies();
	public ADPepperoni createPepperoni();
	public ABClams createClam();

}
