package aStrategy;

public class DuckModel extends DuckAbstract {

	// using only basic constructor
	public DuckModel() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new QuackUsuall();
	}

	@Override
	public void display() {
		System.out.println("I am model duck");
	}

}
