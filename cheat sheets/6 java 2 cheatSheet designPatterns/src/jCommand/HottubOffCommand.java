package jCommand;

public class HottubOffCommand implements ACommand {

	Hottub hottub;
	
	public HottubOffCommand(Hottub hottub) {
		this.hottub = hottub;
	}

	@Override
	public void execute() {
		hottub.jetsOff();
	}

	@Override
	public void undo() {
		hottub.jetsOn();
	}

}
