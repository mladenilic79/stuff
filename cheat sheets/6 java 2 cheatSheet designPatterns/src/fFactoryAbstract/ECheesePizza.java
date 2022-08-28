package fFactoryAbstract;

public class ECheesePizza extends DPizza {

	BPizzaIngredientFactory ingredientFactory;
	
	public ECheesePizza(BPizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}
	
	void prepare() {
		
		System.out.println("Preparing " + name);
		
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		
	}

}
