package jCommand;

public class TVOnCommand implements ACommand {

	TV tv;
	
	public TVOnCommand(TV tv) {
		this.tv = tv;
	}
	
	@Override
	public void execute() {
		tv.on();
	}

	@Override
	public void undo() {
		tv.off();
	}

}
