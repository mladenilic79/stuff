package rCompositeIterator;

import java.util.Iterator;

public abstract class AMenuComponent {

	// composite methods
	public void add(AMenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	public void remove(AMenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	public AMenuComponent getChild(int i) {
		throw new UnsupportedOperationException();
	}

	// operation methods
	public String getName() {
		throw new UnsupportedOperationException();
	}
	public String getDescription() {
		throw new UnsupportedOperationException();
	}
	public double getPrice() {
		throw new UnsupportedOperationException();
	}
	public boolean isVegetarian() {
		throw new UnsupportedOperationException();
	}
	
	public void print() {
		throw new UnsupportedOperationException();
	}
	
	// added iterator
	public Iterator createIterator() {
		throw new UnsupportedOperationException();
	}
}
