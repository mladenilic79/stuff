package aa_exercises;

public class NumberLoop_sumOfTwoCubesInTwoDifferentWaysUpToN {

	public static void main(String[] args) {

		/*
		 * smallest number expressible as the sum of two cubes in two different ways.�
		 * Verify this claim by writing a program that takes an integer command-line
		 * argument n and prints all integers less than or equal to n that can be
		 * expressed as the sum of two cubes in two different ways. In other words, find
		 * distinct positive integers a, b, c, and d such that a^3 + b^3 = c^3 + d^3 =
		 * n. Use four nested for loops.
		 */

		int n = 10000;
		int p = (int) Math.cbrt(n) + 1;
		System.out.println(p);

		for (int i = 1; i < p; i++) {
			
			int ii = i*i*i;

			for (int j = i; j < p; j++) {
				
				int jj = j*j*j;

				for (int k = i + 1; k < p; k++) {
					
					int kk = k*k*k;

					for (int l = k; l < p; l++) {
						
						int ll = l*l*l;

						if (ii + jj == kk + ll && i != k && i != l) {

							System.out.println("ukupno: " + (ii+jj) + " \t\tprvi: " + (ii) + " \tdrugi: " + (jj) + " \t\ttreci: "
									+ (kk) + " \tcetvrti: " + (ll));

						}

					}

				}

			}

		}

	}

}
