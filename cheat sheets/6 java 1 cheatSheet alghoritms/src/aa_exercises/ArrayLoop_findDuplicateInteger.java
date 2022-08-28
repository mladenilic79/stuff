package aa_exercises;

public class ArrayLoop_findDuplicateInteger {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * 4.1.34 Finding a repeated integer. (b) Given a read-only array of n integers,
		 * where each value from 1 to n�1 occurs once and one occurs twice, give an
		 * algorithm that finds the duplicated value, in linear time and constant extra
		 * memory.
		 */

		int[] a = { 2, 3, 4, 5, 6, 6, 7, 1, 8, 9 };

		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					System.out.println("duplicate found " + a[i]);
				}
			}
		}

	}

}
