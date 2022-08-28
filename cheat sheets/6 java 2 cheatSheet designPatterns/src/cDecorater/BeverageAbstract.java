package cDecorater;

// class, abstract class or interface
public abstract class BeverageAbstract {
	
	String description = "unknown beverage";

	public String getDescription() {
		return description;
	}

	// implement in subclass
	public abstract double cost();

}
