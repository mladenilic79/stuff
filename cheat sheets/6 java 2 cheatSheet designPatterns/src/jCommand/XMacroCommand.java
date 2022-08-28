package jCommand;

public class XMacroCommand implements ACommand {

	// receive array of commands
	ACommand[] commands;

	public XMacroCommand(ACommand[] commands) {
		this.commands = commands;
	}

	// execute on mass
	@Override
	public void execute() {
		for (int i = 0; i < commands.length; i++) {
			commands[i].execute();
		}
	}

	@Override
	public void undo() {
		for (int i = 0; i < commands.length; i++) {
			commands[i].undo();
		}
	}

}
