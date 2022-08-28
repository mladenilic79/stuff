package gSingletonBasicLazely;

// singleton basic variant

public class Singleton {
	
	private static Singleton uniqueInstance;

	// other useful instance variables here
	String message = "i am one object only";
	
	private Singleton() {
	}

	// add keyword synchronized in case of using threads
	public static synchronized Singleton getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}
	
	// other useful methods here
	public void messagePrint() {
		System.out.println(message);
	}
	
}
