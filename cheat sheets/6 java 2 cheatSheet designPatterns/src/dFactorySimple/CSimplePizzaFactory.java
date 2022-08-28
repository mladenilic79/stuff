package dFactorySimple;

public class CSimplePizzaFactory {

	// if method static it is called static factory (no instantiation needed,
	// but can't be subclassed also
	public APizza createPizza(String type) {
		
		APizza pizza = null;
		
		if(type.equals("cheese")) {
			pizza = new BCheesePizza();
		} else if (type.equals("pepperoni")) {
			pizza = new BPepperoniPizza();
		} else if (type.equals("veggie")) {
			pizza = new BVeggiePizza();
		}
		
		return pizza;
	}
	
}
