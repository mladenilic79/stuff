package iSingletonDoubleLocking;

/*
With double-checked locking, we first check to see if an instance is created, 
and if not, THEN we synchronize. This way, we only synchronize the first time 
through, just what we want.
*/

public class Singleton {

	/*
	The volatile keyword ensures that multiple threads handle the uniqueInstance
	variable correctly when it is being initialized to the Singleton instance
	*/
	private volatile static Singleton uniqueInstance;

	// other useful instance variables here
	String message = "i am one object only";
	
	private Singleton() {
	}

	public static Singleton getInstance() {
		if (uniqueInstance == null) {
			synchronized (Singleton.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Singleton();
				}
			}
		}
		return uniqueInstance;
	}
	
	// other useful methods here
	public void messagePrint() {
		System.out.println(message);
	}

}
