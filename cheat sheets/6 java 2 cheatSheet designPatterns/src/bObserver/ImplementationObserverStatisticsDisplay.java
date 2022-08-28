package bObserver;

public class ImplementationObserverStatisticsDisplay implements InterfaceObserver {

	// main data to receive
	private float temperature;
	private float humidity;
	private float pressure;
	
	public ImplementationObserverStatisticsDisplay() {
	}

	// setter like
	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}

}
