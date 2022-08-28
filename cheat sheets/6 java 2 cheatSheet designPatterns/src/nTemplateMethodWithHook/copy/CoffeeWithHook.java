package nTemplateMethodWithHook.copy;

public class CoffeeWithHook extends CaffeineBeverageWithHook {

	@Override
	void brew() {
		System.out.println("Dripping Coffee through filter");
	}

	@Override
	void addCondiments() {
		System.out.println("Adding Sugar and Milk");
	}

	// optionally override
	@Override
	public boolean customerWantsCondiments() {
		return false;
	}

}
