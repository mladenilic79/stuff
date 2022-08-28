package eFactoryMethod;

public class BChicagoStyleVeggiePizza extends APizza {
	
	public BChicagoStyleVeggiePizza() {

		name = "Chicago Style Veggie Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
		
		toppings.add("Shredded Mozzarella Cheese");
		
	}
	
	@Override
	void cut() {
		System.out.println("Cutting the pizza into square slices");
	}

}
