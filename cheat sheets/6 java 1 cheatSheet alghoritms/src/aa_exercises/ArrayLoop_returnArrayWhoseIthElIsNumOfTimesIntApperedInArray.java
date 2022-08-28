package aa_exercises;

public class ArrayLoop_returnArrayWhoseIthElIsNumOfTimesIntApperedInArray {

	public static void main(String[] args) {

		/*
		 * 2.1.19 Write a static method histogram() that takes an int array a[] and an
		 * integer m as arguments and returns an array of length m whose ith element is
		 * the number of times the integer i appeared in a[]. Assuming the values in a[]
		 * are all between 0 and m-1, the sum of the values in the returned array should
		 * equal a.length.
		 */

		int[] arr = { 0, 1, 3, 2, 6, 2, 4, 5, 7, 4 };
		int n = 5;

		int[] a = new int[n];

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > 4) {
				continue;
			}

			int temp = arr[i];

			a[temp]++;

		}

		for (int i : a) {
			System.out.println(i);
		}

	}

}
