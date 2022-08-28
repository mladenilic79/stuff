package kAdapter;

public class ZMainDuckTestDrive {

	// receive duck object & test it
	static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}

	public static void main(String[] args) {

		MallardDuck duck = new MallardDuck();
		WildTurkey turkey = new WildTurkey();
		
		// put duck adapter around turkey
		Duck turkeyAdapter = new ZaTurkeyAdapter(turkey);
		
		System.out.println("the duck says...");
		duck.quack();
		duck.fly();
		
		System.out.println("The Turkey says...");
		turkey.gobble();
		turkey.fly();
		
		System.out.println("\ntest: duck says...");
		testDuck(duck);
		
		System.out.println("\ntest: turkey in duck adapter says...");
		testDuck(turkeyAdapter);

	}

}
