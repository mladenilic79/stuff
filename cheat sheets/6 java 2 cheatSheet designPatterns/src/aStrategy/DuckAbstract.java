package aStrategy;

public abstract class DuckAbstract {
	
	// composition
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	// using only basic constructor
	public DuckAbstract() {
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

	public abstract void display();
	
	// delegate to the behavior class
	public void performFly() {
		flyBehavior.fly();
	}

	// delegate to the behavior class
	public void performQuack() {
		quackBehavior.quack();
	}
	
	public void swim() {
		System.out.println("all ducks swim, even decoys");
	}
	
}
