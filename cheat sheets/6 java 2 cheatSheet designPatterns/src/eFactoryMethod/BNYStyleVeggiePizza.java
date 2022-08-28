package eFactoryMethod;

public class BNYStyleVeggiePizza extends APizza {
	
	public BNYStyleVeggiePizza() {
		
		name = "NY Style Sauce and Veggie Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		
		toppings.add("Grated Reggiano Cheese");
		
	}
	
	@Override
	void bake() {
		System.out.println("with a chery on top");
	}

}
