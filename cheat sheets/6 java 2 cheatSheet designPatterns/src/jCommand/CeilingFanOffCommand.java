package jCommand;

public class CeilingFanOffCommand implements ACommand {

	CeilingFan ceilingFan;

	public CeilingFanOffCommand(CeilingFan ceilingFan) {
		this.ceilingFan = ceilingFan;
	}

	@Override
	public void execute() {
		ceilingFan.off();
	}

	@Override
	public void undo() {
		ceilingFan.low();
	}

}
