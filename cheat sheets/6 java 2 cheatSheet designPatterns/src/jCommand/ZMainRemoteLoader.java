package jCommand;

public class ZMainRemoteLoader {

	public static void main(String[] args) {

		// create remote control object
		YRemoteControl remoteControl = new YRemoteControl();
		
		// Create all the devices in their proper locations
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		CeilingFan ceilingFan= new CeilingFan("Living Room");
		GarageDoor garageDoor = new GarageDoor();
		Stereo stereo = new Stereo("Living Room");
		TV tv = new TV("Living Room");
		Hottub hottub = new Hottub();
		
		// create all command objects
		
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight); 
		LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
		
		CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
		CeilingFanMediumCommand ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
		CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
		
		GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
		GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);
		
		StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		
		TVOnCommand tvOn = new TVOnCommand(tv);
		TVOffCommand tvOff = new TVOffCommand(tv);
		
		HottubOnCommand hottubOn = new HottubOnCommand(hottub);
		HottubOffCommand hottubOff = new HottubOffCommand(hottub);
		
		ACommand[] partyOn = { livingRoomLightOn, stereoOnWithCD, tvOn, hottubOn, ceilingFanMedium};
		ACommand[] partyOff = { livingRoomLightOff, stereoOff, tvOff, hottubOff, ceilingFanHigh};
		XMacroCommand partyOnMacro = new XMacroCommand(partyOn);
		XMacroCommand partyOffMacro = new XMacroCommand(partyOff);
		
		// load commands into the remote slots
		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
		remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
		remoteControl.setCommand(3, garageDoorUp, garageDoorDown);
		remoteControl.setCommand(4, stereoOnWithCD, stereoOff);
		remoteControl.setCommand(5, tvOn, tvOff);
		remoteControl.setCommand(6, partyOnMacro, partyOffMacro);
		
		// print each remote slot and the command that it is assigned to
		System.out.println(remoteControl);
		
		// pushing buttons
		
		remoteControl.onButtonWasPushed(0);
		remoteControl.undoButtonWasPushed();
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		remoteControl.undoButtonWasPushed();
		remoteControl.offButtonWasPushed(0);
		
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(1);
		remoteControl.offButtonWasPushed(1);
		remoteControl.onButtonWasPushed(2);
		remoteControl.offButtonWasPushed(2);
		remoteControl.onButtonWasPushed(3);
		remoteControl.offButtonWasPushed(3);
		remoteControl.onButtonWasPushed(4);
		remoteControl.offButtonWasPushed(4);
		remoteControl.onButtonWasPushed(5);
		remoteControl.offButtonWasPushed(5);
		remoteControl.onButtonWasPushed(6);
		remoteControl.offButtonWasPushed(6);

	}

}
