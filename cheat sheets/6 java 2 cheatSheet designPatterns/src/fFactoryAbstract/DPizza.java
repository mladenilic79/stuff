package fFactoryAbstract;

public abstract class DPizza {
	
	String name;
	ACDough dough;
	AESauce sauce;
	AFVeggies veggies[];
	AACheese cheese;
	ADPepperoni pepperoni;
	ABClams clam;

	abstract void prepare();
	
	void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}
	
	void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}
	
	void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	String getName() {
		return name;
	}
	
	public String toString() {
		return name;
		// code to print pizza here
	}

}
