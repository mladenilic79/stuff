package dFactorySimple;

public class BPepperoniPizza extends APizza {
	
	public BPepperoniPizza() {

		name = "Chicago Style Pepperoni Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
		
		toppings.add("Shredded Mozzarella Cheese");
		
	}
	
	@Override
	void cut() {
		System.out.println("Cutting the pizza into square slices");
	}

}
