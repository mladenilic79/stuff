package jCommand;

public class HottubOnCommand implements ACommand {

	Hottub hottub;
	
	public HottubOnCommand(Hottub hottub) {
		this.hottub = hottub;
	}

	@Override
	public void execute() {
		hottub.jetsOn();
	}

	@Override
	public void undo() {
		hottub.jetsOff();
	}

}
