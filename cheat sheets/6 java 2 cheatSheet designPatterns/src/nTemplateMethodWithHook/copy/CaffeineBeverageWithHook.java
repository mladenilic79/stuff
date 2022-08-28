package nTemplateMethodWithHook.copy;

public abstract class CaffeineBeverageWithHook {

	final void prepareRecipe() {
		
		boilWater();
		
		brew();
		
		pourInCup();
		
		// hook
		if (customerWantsCondiments()) {
			addCondiments();
		}
		
	}

	abstract void brew();

	abstract void addCondiments();

	void boilWater() {
		System.out.println("Boiling water");
	}

	void pourInCup() {
		System.out.println("Pouring into cup");
	}
	
	// hook (subclass can override this method, but doesn’t have to)
	// use when part of algorithm is optional
	boolean customerWantsCondiments() {
		return true;
	}

}
