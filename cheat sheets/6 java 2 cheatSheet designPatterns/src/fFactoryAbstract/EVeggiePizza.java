package fFactoryAbstract;

public class EVeggiePizza extends DPizza {

	BPizzaIngredientFactory ingredientFactory;
	
	public EVeggiePizza(BPizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
	
	void prepare() {
		
		System.out.println("Preparing " + name);
		
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		
	}

}
