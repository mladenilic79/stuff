package jCommand;

public class StereoOffCommand implements ACommand {

	Stereo stereo;
	
	public StereoOffCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.off();
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
