package dFactorySimple;

public class DPizzaStore {

	CSimplePizzaFactory factory;
	
	public DPizzaStore(CSimplePizzaFactory factory) {
		this.factory = factory;
	}
	
	public APizza orderPizza(String type) {
		
		APizza pizza;
		
		pizza = factory.createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
		
	}

}
