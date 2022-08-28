package rCompositeIterator;

import java.util.Iterator;

public class BMenuItem extends AMenuComponent {

	String name;
	String description;
	boolean vegetarian;
	double price;

	public BMenuItem(String name, String description, boolean vegetarian, double price) {
		this.name = name;
		this.description = description;
		this.vegetarian = vegetarian;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public void print() {
		System.out.print(" " + getName());
		if (isVegetarian()) {
			System.out.print("(v)");
		}
		System.out.println(", " + getPrice());
		System.out.println(" -- " + getDescription());
	}

	/*
	iterator that always returns false when hasNext() is called because 
	MenuItem has nothing to iterate over
	We could return null from createIterator(), but then we’d need conditional 
	code in the client to see if null was returned or not.
	*/
	public Iterator createIterator() {
		return new NullIterator();
	}

}
