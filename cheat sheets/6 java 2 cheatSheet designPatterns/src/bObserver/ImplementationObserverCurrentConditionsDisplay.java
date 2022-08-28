package bObserver;

public class ImplementationObserverCurrentConditionsDisplay implements InterfaceObserver {
	
	// main data to receive
	private float temperature;
	private float humidity;
	
	public ImplementationObserverCurrentConditionsDisplay() {
	}

	// setter like
	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
	}

}
