package aStrategy;

public class DuckMallard extends DuckAbstract {

	// using only basic constructor
	public DuckMallard() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new QuackUsuall();
	}

	@Override
	public void display() {
		System.out.println("I am mallard duck");
	}

}
