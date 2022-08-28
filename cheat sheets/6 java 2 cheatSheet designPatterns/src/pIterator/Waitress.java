package pIterator;

import java.util.Iterator;

public class Waitress {

	BMenu pancakeHouseMenu;
	BMenu dinerMenu;
	BMenu cafeMenu;

	public Waitress(BMenu pancakeHouseMenu, BMenu dinerMenu, BMenu cafeMenu) {
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
		this.cafeMenu = cafeMenu;
	}

	public void printMenu() {
		Iterator pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator dinerIterator = dinerMenu.createIterator();
		Iterator cafeIterator = cafeMenu.createIterator();
		
		System.out.println("MENU\n----\nBREAKFAST");
		printMenu(pancakeIterator);
		
		System.out.println("\nLUNCH");
		printMenu(dinerIterator);
		
		System.out.println("\nDINNER");
		printMenu(cafeIterator);
	}

	private void printMenu(Iterator iterator) {
		while (iterator.hasNext()) {
			AMenuItem menuItem = (AMenuItem) iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
		}
	}

	// other methods here

}
