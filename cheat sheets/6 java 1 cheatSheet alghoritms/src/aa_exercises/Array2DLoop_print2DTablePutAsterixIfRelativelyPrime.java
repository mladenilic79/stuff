package aa_exercises;

public class Array2DLoop_print2DTablePutAsterixIfRelativelyPrime {
	
	public static void main(String[] args) throws InterruptedException {

		// Write a program RelativelyPrime that takes an integer command-line
		// argument n and prints an n-by-n table such that there is an * in row i
		// and column j if the gcd of i and j is 1 (i and j are relatively prime)
		// and a space in that position otherwise.

		int n = 10;
		int gcd = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				int a = i;
				int b = j;

				for(int k = 1; k <= a && k <= b; k++)
		        {
		            if(a % k==0 && b % k==0)
		                gcd = k;
		        }

				if (gcd != 1) {
					System.out.print("*");
				} else {
					System.out.print(".");
				}

			}
			System.out.println();
		}

	}

}
