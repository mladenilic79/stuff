package hSingletonEagerly;

/*
If your application always creates and uses an instance of the Singleton or the 
overhead of creation and runtime aspects of the Singleton are not onerous, you 
may want to create your Singleton eagerly (no overhead of synchonized method)
*/

public class Singleton {
	
	// created eagerly
	private static Singleton uniqueInstance = new Singleton();

	// other useful instance variables here
	String message = "i am one object only";
	
	private Singleton() {
	}

	public static Singleton getInstance() {
		return uniqueInstance;
	}
	
	// other useful methods here
	public void messagePrint() {
		System.out.println(message);
	}

}
