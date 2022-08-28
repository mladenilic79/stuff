package nTemplateMethodWithHook.copy;

public class TeaWithHook extends CaffeineBeverageWithHook{

	@Override
	void brew() {
		System.out.println("Steeping the tea");
	}

	@Override
	void addCondiments() {
		System.out.println("Adding Lemon");
	}
	
	// optionally override
	@Override
	public boolean customerWantsCondiments() {
		return false;
	}

}
