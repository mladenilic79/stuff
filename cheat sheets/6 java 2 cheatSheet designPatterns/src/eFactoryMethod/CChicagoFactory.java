package eFactoryMethod;

public class CChicagoFactory extends DPizzaStore {

	APizza createPizza(String item) {
		
		if (item.equals("cheese")) {
			return new BChicagoStyleCheesePizza();
		} else if (item.equals("veggie")) {
			return new BChicagoStyleVeggiePizza();
		} else if (item.equals("pepperoni")) {
			return new BChicagoStylePepperoniPizza();
		} else return null;
		
	}

}
