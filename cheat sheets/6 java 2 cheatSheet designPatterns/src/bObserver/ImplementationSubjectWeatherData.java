package bObserver;

import java.util.ArrayList;

public class ImplementationSubjectWeatherData implements InterfaceSubject {
	
	// list to hold observers
	private ArrayList<InterfaceObserver> observers = new ArrayList<>();
	
	// main data
	private float temperature;
	private float humidity;
	private float pressure;

	public ImplementationSubjectWeatherData() {
	}

	// observer pattern methods
	@Override
	public void registerObserver(InterfaceObserver o) {
		observers.add(o);	
	}
	@Override
	public void removeObserver(InterfaceObserver o) {
		observers.remove(o);
	}
	@Override
	public void notifyObservers() {
		for(int i=0; i<observers.size(); i++) {
			InterfaceObserver observer = (InterfaceObserver) observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
	// intermediate method, not needed ???
	public void measurmentsChanded() {
		notifyObservers();
	}
	
	// setter like
	public void setMeasurments(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurmentsChanded();
	}

}
