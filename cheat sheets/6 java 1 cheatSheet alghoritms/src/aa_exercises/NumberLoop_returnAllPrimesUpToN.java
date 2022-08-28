package aa_exercises;

public class NumberLoop_returnAllPrimesUpToN {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * 1.3.36 Counting primes. Write a program PrimeCounter that takes an integer
		 * command-line argument n and finds the number of primes less than or equal to
		 * n. Use it to print out the number of primes less than or equal to 10 million.
		 * Note : If you are not careful, your program may not finish in a reasonable
		 * amount of time!
		 */

		int n = 100;

		for (int i = 1; i <= n; i += 2) {

			boolean isPrime = true;

			for (int j = 2; j < (i / 2) + 1; j++) {

				if (i % j == 0) {
					isPrime = false;
				}

			}

			if (isPrime == true) {
				System.out.println(i);
			}

		}

	}

}
