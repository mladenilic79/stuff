package fFactoryAbstract;

public class EPepperoniPizza extends DPizza {
	
	BPizzaIngredientFactory ingredientFactory;
	
	public EPepperoniPizza(BPizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
	
	void prepare() {
		
		System.out.println("Preparing " + name);
		
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		
	}

}
