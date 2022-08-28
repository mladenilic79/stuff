package fFactoryAbstract;

public class GCaliforniaFactory extends FPizzaStore {

protected DPizza createPizza(String item) {
		
		DPizza pizza = null;
		
		BPizzaIngredientFactory ingredientFactory =
				new CCaliforniaPizzaIngredientFactory();
		
		if (item.equals("cheese")) {
			pizza = new ECheesePizza(ingredientFactory);
			pizza.setName("California Style Cheese Pizza");
		} else if (item.equals("veggie")) {
			pizza = new EVeggiePizza(ingredientFactory);
			pizza.setName("California Style Veggie Pizza");
		} else if (item.equals("pepperoni")) {
			pizza = new EPepperoniPizza(ingredientFactory);
			pizza.setName("California Style Pepperoni Pizza");
		}
		
		return pizza;
		
	}

}
