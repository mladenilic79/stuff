package bObserver;

// must know who are observers
public interface InterfaceSubject {
	
	public void registerObserver(InterfaceObserver o);
	public void removeObserver(InterfaceObserver o);
	public void notifyObservers();

}
