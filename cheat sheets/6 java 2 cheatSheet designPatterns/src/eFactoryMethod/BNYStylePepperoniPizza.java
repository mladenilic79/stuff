package eFactoryMethod;

public class BNYStylePepperoniPizza extends APizza {
	
	public BNYStylePepperoniPizza() {
		
		name = "NY Style Sauce and Pepperoni Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		
		toppings.add("Grated Reggiano Cheese");
		
	}
	
	@Override
	void bake() {
		System.out.println("with a chery on top");
	}

}
