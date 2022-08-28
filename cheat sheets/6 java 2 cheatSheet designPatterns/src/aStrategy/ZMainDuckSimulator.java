package aStrategy;

public class ZMainDuckSimulator {
	
	public static void main(String[] args) {
		
		DuckAbstract mallard = new DuckMallard();
		mallard.performFly();
		mallard.performQuack();
		
		DuckModel model = new DuckModel();
		model.performFly();
		model.performQuack();
		model.setFlyBehavior(new FlyRocketPowered());
		model.setQuackBehavior(new QuackMute());
		model.performFly();
		model.performQuack();
		
		
	}

}
