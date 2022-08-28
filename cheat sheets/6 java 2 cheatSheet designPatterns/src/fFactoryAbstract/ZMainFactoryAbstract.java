package fFactoryAbstract;

public class ZMainFactoryAbstract {

	public static void main(String[] args) {

		FPizzaStore nyStore = new GNYFactory();
		DPizza pizza = nyStore.orderPizza("cheese");
		
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");
		
		FPizzaStore chicagoStore = new GChicagoFactory();
		pizza = chicagoStore.orderPizza("cheese");
		
		System.out.println("Joel ordered a " + pizza.getName() + "\n");

	}

}
