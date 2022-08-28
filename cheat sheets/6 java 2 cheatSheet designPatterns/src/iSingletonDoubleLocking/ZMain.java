package iSingletonDoubleLocking;

public class ZMain {

	public static void main(String[] args) {

		// get single object
		Singleton singleObject = Singleton.getInstance();

		singleObject.messagePrint();

	}

}
