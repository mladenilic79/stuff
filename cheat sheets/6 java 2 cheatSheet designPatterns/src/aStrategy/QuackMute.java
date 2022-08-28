package aStrategy;

public class QuackMute implements QuackBehavior{

	@Override
	public void quack() {
		System.out.println("silence");
	}

}
