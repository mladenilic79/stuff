package eFactoryMethod;

public class CNYFactory extends DPizzaStore {

	APizza createPizza(String item) {
		
		if (item.equals("cheese")) {
			return new BNYStyleCheesePizza();
		} else if (item.equals("veggie")) {
			return new BNYStyleVeggiePizza();
		} else if (item.equals("pepperoni")) {
			return new BNYStylePepperoniPizza();
		} else return null;
		
	}

}
