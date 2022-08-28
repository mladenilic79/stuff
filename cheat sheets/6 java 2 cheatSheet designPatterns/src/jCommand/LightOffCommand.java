package jCommand;

public class LightOffCommand implements ACommand {

	Light light;
	
	public LightOffCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.off();
	}
	
	@Override
	public void undo() {
		light.on();
	}

}
