package qComposite;

import java.util.ArrayList;

public class ZMain {

	public static void main(String[] args) {

		// menus
		AMenuComponent pancakeHouseMenu = new BMenu("PANCAKE HOUSE MENU", "Breakfast");
		AMenuComponent dinerMenu = new BMenu("DINER MENU", "Lunch");
		AMenuComponent cafeMenu = new BMenu("CAFE MENU", "Dinner");
		AMenuComponent dessertMenu = new BMenu("DESSERT MENU", "Dessert of course!");
		
		// top level menu
		AMenuComponent allMenus = new BMenu("ALL MENUS", "All menus combined");
		allMenus.add(pancakeHouseMenu);
		allMenus.add(dinerMenu);
		allMenus.add(cafeMenu);
		
		// add menu items here
		dinerMenu.add(new BMenuItem("Pasta", "Spaghetti with Marinara Sauce, and a slice of sourdough bread", true, 3.89));
		dinerMenu.add(dessertMenu);
		dessertMenu.add(new BMenuItem("Apple Pie", "Apple pie with a flakey crust, topped with vanilla icecream", true, 1.59));
		
		// add more menu items here
		
		Waitress waitress = new Waitress(allMenus);
		waitress.printMenu();

	}

}
