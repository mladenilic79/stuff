package dFactorySimple;

public class BCheesePizza extends APizza {

	public BCheesePizza() {

		name = "Chicago Style Deep Dish Cheese Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
		
		toppings.add("Shredded Mozzarella Cheese");
		
	}
	
	@Override
	void cut() {
		System.out.println("Cutting the pizza into square slices");
	}

}
