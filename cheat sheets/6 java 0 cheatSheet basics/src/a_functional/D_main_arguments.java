package a_functional;

/*
run with: run configurations, go to arguments tab, put arguments with space
beetween them, than run (<string> <int>)
*/
public class D_main_arguments {

	// main receives array of strings as arguments
	public static void main(String[] args) {
		
		int count = 0;
		
		// check for number of inputed arguments
		if (args.length < 2) {
			System.out.println("run with: run configurations, go to arguments "
					+ "tab, put arguments with space beetween them, than run");
			System.exit(1);
		}
		
		// parse number from arguments
		count = Integer.parseInt(args[1]);
		
		// using arguments
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(count);

	}

}
