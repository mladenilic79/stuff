package lFacade;

public class ZMainHomeTheaterTestDrive {

	public static void main(String[] args) {

		Amplifier amp = new Amplifier();
		Tuner tuner = new Tuner();
		DvdPlayer dvd = new DvdPlayer();
		CdPlayer cd = new CdPlayer();
		Projector projector = new Projector();
		TheaterLights screen = new TheaterLights();
		Screen lights = new Screen();
		PopcornPopper popper = new PopcornPopper();
		
		XHomeTheaterFacade homeTheater =
		new XHomeTheaterFacade(amp, tuner, dvd, cd, projector, screen, lights, popper);
		
		homeTheater.watchMovie("Raiders of the Lost Ark");
		homeTheater.endMovie();

	}

}
