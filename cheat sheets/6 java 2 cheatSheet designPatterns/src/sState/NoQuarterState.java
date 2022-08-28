package sState;

public class NoQuarterState implements BState {

	AGumballMachine gumballMachine;

	public NoQuarterState(AGumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	@Override
	public void ejectQuarter() {
		System.out.println("You haven�t inserted a quarter");
	}

	@Override
	public void turnCrank() {
		System.out.println("You turned, but there�s no quarter");
	}

	@Override
	public void dispense() {
		System.out.println("You need to pay first");
	}

}
