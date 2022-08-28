package dFactorySimple;

public class ZMainFactorySimple {

	public static void main(String[] args) {
		
		CSimplePizzaFactory factory = new CSimplePizzaFactory();
		DPizzaStore store = new DPizzaStore(factory);
		APizza pizza = store.orderPizza("cheese");
		
		System.out.println("Joel ordered a " + pizza.getName() + "\n");

	}

}
