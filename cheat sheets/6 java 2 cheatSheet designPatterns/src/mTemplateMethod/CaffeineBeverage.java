package mTemplateMethod;

public abstract class CaffeineBeverage {

	// template method (final?)
	final void prepareRecipe() {
		
		// primitive operation
		boilWater();
		
		// concrete operation
		brew();
		
		// primitive operation
		pourInCup();
		
		// concrete operation
		addCondiments();

	}

	abstract void brew();

	abstract void addCondiments();

	void boilWater() {
		System.out.println("Boiling water");
	}

	void pourInCup() {
		System.out.println("Pouring into cup");
	}

}
