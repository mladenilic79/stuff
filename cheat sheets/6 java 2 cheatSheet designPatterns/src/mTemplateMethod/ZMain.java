package mTemplateMethod;

public class ZMain {

	public static void main(String[] args) {

		Tea myTea = new Tea();
		Coffe coffe = new Coffe();
		
		System.out.println("\nMaking tea...");
		myTea.prepareRecipe();
		
		System.out.println("\nMaking coffee...");
		coffe.prepareRecipe();

	}

}
