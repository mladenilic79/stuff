package cDecorater;

public class StarbuzzCoffe {

	public static void main(String[] args) {
		
		// beverage without condiments
		BeverageAbstract beverage = new BeverageImplEspresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());

		System.out.println();
		
		// beverage with multiple wraps
		BeverageAbstract beverage2 = new BeverageImplHouseblend();
		beverage2 = new CondimentDecoraterImplSoy(beverage2);
		beverage2 = new CondimentDecoraterImplMocha(beverage2);
		beverage2 = new CondimentDecoraterImplWhip(beverage2);
		System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
		
	}

}
