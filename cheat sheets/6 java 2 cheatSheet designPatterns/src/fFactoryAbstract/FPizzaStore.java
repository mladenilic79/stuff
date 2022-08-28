package fFactoryAbstract;

public abstract class FPizzaStore {
	
	public DPizza orderPizza(String type) {
		
		DPizza pizza;
		
		pizza = createPizza(type);
		
		pizza.prepare();
		
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
		
	}
	
	abstract DPizza createPizza(String type);

}
