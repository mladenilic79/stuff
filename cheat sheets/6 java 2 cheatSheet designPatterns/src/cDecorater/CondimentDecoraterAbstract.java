package cDecorater;

// decorater abstract class (extends/implements regular class &
// reimplements regular methods from it as abstract)
public abstract class CondimentDecoraterAbstract extends BeverageAbstract {
	
	// link to beverage we are wrapping/decorating
	BeverageAbstract beverage;
	
	public abstract String getDescription();

}
