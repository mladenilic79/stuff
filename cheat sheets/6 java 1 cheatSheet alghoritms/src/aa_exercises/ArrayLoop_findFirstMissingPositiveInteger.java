
/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Stripe.

Given an array of integers, find the first missing positive integer in linear 
time and constant space. In other words, find the lowest positive integer that 
does not exist in the array. The array can contain duplicates and negative 
numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] 
should give 3.

You can modify the input array in-place.
 */

package aa_exercises;

public class ArrayLoop_findFirstMissingPositiveInteger {

	public static void main(String[] args) {

		int[] arr = { -5, 3, 2, 1, 0, -1, 5, -9, 4, 1, 88, 9 };

		// brute force, check one by one
		int match = 0;
		int counter = 0;
		loop:
		while (true) {
			counter++;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == counter) {
					break;
				} else if(i==arr.length-1) {
					match = counter;
					break loop;
				}
			}
		}

		System.out.println(match);

		// sort & take only positive, check for lowest num, repeat

	}

}
