package qComposite;

public class Waitress {

	AMenuComponent allMenus;

	public Waitress(AMenuComponent allMenus) {
		this.allMenus = allMenus;
	}

	public void printMenu() {
		allMenus.print();
	}

}
