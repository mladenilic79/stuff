package jCommand;

public class YRemoteControl {

	// On and Off commands, which we’ll hold in corresponding arrays
	ACommand[] onCommands;
	ACommand[] offCommands;
	ACommand undoCommand;

	// instantiate and initialize the on and off arrays
	public YRemoteControl() {
		onCommands = new ACommand[7];
		offCommands = new ACommand[7];
		
		ACommand noCommand = new BNoCommand();
		for (int i = 0; i < 7; i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
		undoCommand = noCommand;
	}

	// This method takes a slot position and an On and Off command to be stored
	// in that slot for later use
	public void setCommand(int slot, ACommand onCommand, ACommand offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}

	// When an On or Off button is pressed, the hardware takes care of calling 
	// the corresponding methods
	public void onButtonWasPushed(int slot) {
		onCommands[slot].execute();
		undoCommand = onCommands[slot];
	}
	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute();
		undoCommand = offCommands[slot];
	}
	public void undoButtonWasPushed() {
		undoCommand.undo();
	}
	
	// We’ve overwritten toString() to print out each slot and its commands
	public String toString() {
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control -------\n");
		for (int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " 
					+ onCommands[i].getClass().getName() + " " 
					+ offCommands[i].getClass().getName() + "\n");
		}
		return stringBuff.toString();
	}

}
