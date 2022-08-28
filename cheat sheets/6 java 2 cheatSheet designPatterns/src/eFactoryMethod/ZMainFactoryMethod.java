package eFactoryMethod;

public class ZMainFactoryMethod {

	public static void main(String[] args) {

		DPizzaStore nyStoreFactory = new CNYFactory();
		APizza pizza = nyStoreFactory.orderPizza("cheese");
		
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");
		
		DPizzaStore chicagoStoreFactory = new CChicagoFactory();
		pizza = chicagoStoreFactory.orderPizza("cheese");
		
		System.out.println("Joel ordered a " + pizza.getName() + "\n");

	}

}
