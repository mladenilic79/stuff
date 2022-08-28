package jCommand;

public class TVOffCommand implements ACommand {

	TV tv;
	
	public TVOffCommand(TV tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		tv.off();
		
	}

	@Override
	public void undo() {
		tv.on();
	}

}
