package eFactoryMethod;

public abstract class DPizzaStore {
	
	public APizza orderPizza(String type) {
		
		APizza pizza;
		
		pizza = createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
		
	}
	
	abstract APizza createPizza(String type);

}
