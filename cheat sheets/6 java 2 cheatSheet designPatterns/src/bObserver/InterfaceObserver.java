package bObserver;

// must know what data will receive
public interface InterfaceObserver {
	
	public void update(float temperature, float humidity, float pressure);

}
