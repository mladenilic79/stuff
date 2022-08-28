package fFactoryAbstract;

public class GNYFactory extends FPizzaStore {

	protected DPizza createPizza(String item) {
		
		DPizza pizza = null;
		
		BPizzaIngredientFactory ingredientFactory =
				new CNYPizzaIngredientFactory();
		
		if (item.equals("cheese")) {
			pizza = new ECheesePizza(ingredientFactory);
			pizza.setName("New York Style Cheese Pizza");
		} else if (item.equals("veggie")) {
			pizza = new EVeggiePizza(ingredientFactory);
			pizza.setName("New York Style Veggie Pizza");
		} else if (item.equals("pepperoni")) {
			pizza = new EPepperoniPizza(ingredientFactory);
			pizza.setName("New York Style Pepperoni Pizza");
		}
		
		return pizza;
		
	}

}
