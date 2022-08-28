package sState;

public class AGumballMachine {

	BState soldOutState;
	BState noQuarterState;
	BState hasQuarterState;
	BState soldState;
	BState winnerState;
	
	BState state = soldOutState;
	int count = 0;

	public AGumballMachine(int numberGumballs) {
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);
		this.count = numberGumballs;
		if (numberGumballs > 0) {
			state = noQuarterState;
		}
	}

	public void insertQuarter() {
		state.insertQuarter();
	}

	public void ejectQuarter() {
		state.ejectQuarter();
	}

	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	void setState(BState state) {
		this.state = state;
	}

	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
		}
	}

	public BState getSoldOutState() {
		return soldOutState;
	}

	public void setSoldOutState(BState soldOutState) {
		this.soldOutState = soldOutState;
	}

	public BState getNoQuarterState() {
		return noQuarterState;
	}

	public void setNoQuarterState(BState noQuarterState) {
		this.noQuarterState = noQuarterState;
	}

	public BState getHasQuarterState() {
		return hasQuarterState;
	}

	public void setHasQuarterState(BState hasQuarterState) {
		this.hasQuarterState = hasQuarterState;
	}

	public BState getSoldState() {
		return soldState;
	}

	public void setSoldState(BState soldState) {
		this.soldState = soldState;
	}

	public BState getWinnerState() {
		return winnerState;
	}

	public void setWinnerState(BState winnerState) {
		this.winnerState = winnerState;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public BState getState() {
		return state;
	}
	
	// More methods here
}
