package eFactoryMethod;

public class BNYStyleCheesePizza extends APizza {

	public BNYStyleCheesePizza() {
		
		name = "NY Style Sauce and Cheese Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		
		toppings.add("Grated Reggiano Cheese");
		
	}
	
	@Override
	void bake() {
		System.out.println("with a chery on top");
	}

}
