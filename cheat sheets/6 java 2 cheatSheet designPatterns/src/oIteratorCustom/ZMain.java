package oIteratorCustom;

import java.util.ArrayList;

public class ZMain {

	public static void main(String[] args) {

		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		DinerMenu dinerMenu = new DinerMenu();
		
		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
		
		waitress.printMenu();

	}

}
