package jCommand;

public class StereoOnWithCDCommand implements ACommand {

	Stereo stereo;

	public StereoOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.on();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
