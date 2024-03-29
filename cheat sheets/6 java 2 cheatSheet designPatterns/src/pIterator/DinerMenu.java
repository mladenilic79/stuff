package pIterator;

import java.util.Iterator;

public class DinerMenu implements BMenu {

	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	AMenuItem[] menuItems;

	public DinerMenu() {
		menuItems = new AMenuItem[MAX_ITEMS];
		addItem("Vegetarian BLT", "(Fakin�) Bacon with lettuce & tomato on whole wheat", true, 2.99);
		addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);
		addItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 3.29);
		addItem("Hotdog", "A hot dog, with saurkraut, relish, onions, topped with cheese", false, 3.05);
		// a couple of other Diner Menu items added here
	}

	public void addItem(String name, String description, boolean vegetarian, double price) {
		AMenuItem menuItem = new AMenuItem(name, description, vegetarian, price);
		if (numberOfItems >= MAX_ITEMS) {
			System.err.println("Sorry, menu is full! Can�t add item to menu");
		} else {
			menuItems[numberOfItems] = menuItem;
			numberOfItems = numberOfItems + 1;
		}
	}

	public Iterator createIterator() {
		return new DinerMenuIterator(menuItems);
	}

	// other menu methods here

}
