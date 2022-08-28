package kAdapter;

// make turkey sound like is a duck
public class ZaTurkeyAdapter implements Duck {

	Turkey turkey;

	public ZaTurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}

	@Override
	public void quack() {
		turkey.gobble();
	}

	@Override
	public void fly() {
		for (int i = 0; i < 5; i++) {
			turkey.fly();
		}
	}

}
