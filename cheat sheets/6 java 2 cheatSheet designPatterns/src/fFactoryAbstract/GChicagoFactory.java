package fFactoryAbstract;

public class GChicagoFactory extends FPizzaStore {

	protected DPizza createPizza(String item) {
		
		DPizza pizza = null;
		
		BPizzaIngredientFactory ingredientFactory =
				new CChicagoPizzaIngredientFactory();
		
		if (item.equals("cheese")) {
			pizza = new ECheesePizza(ingredientFactory);
			pizza.setName("Chicago Style Cheese Pizza");
		} else if (item.equals("veggie")) {
			pizza = new EVeggiePizza(ingredientFactory);
			pizza.setName("Chicago Style Veggie Pizza");
		} else if (item.equals("pepperoni")) {
			pizza = new EPepperoniPizza(ingredientFactory);
			pizza.setName("Chicago Style Pepperoni Pizza");
		}
		return pizza;
			
	}

}
