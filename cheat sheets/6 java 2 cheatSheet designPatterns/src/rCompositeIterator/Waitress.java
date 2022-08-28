package rCompositeIterator;

import java.util.Iterator;

public class Waitress {

	AMenuComponent allMenus;

	public Waitress(AMenuComponent allMenus) {
		this.allMenus = allMenus;
	}

	public void printMenu() {
		allMenus.print();
	}

	public void printVegetarianMenu() {
		Iterator iterator = allMenus.createIterator();
		System.out.println("\nVEGETARIAN MENU\n----");
		while (iterator.hasNext()) {
			AMenuComponent menuComponent = (AMenuComponent) iterator.next();
			try {
				if (menuComponent.isVegetarian()) {
					menuComponent.print();
				}
			} catch (UnsupportedOperationException e) {
			}
		}
	}

}
