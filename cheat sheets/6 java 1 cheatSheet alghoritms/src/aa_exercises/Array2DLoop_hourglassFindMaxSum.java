
/*
Given a 2D Array,

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0

We define an hourglass in to be a subset of values with indices falling in this 
pattern in graphical representation:

a b c
  d
e f g

There are hourglasses in , and an hourglass sum is the sum of an hourglass' 
values. Calculate the hourglass sum for every hourglass in then print the 
maximum hourglass sum.

For example, given the 2D array:

-9 -9 -9  1 1 1 
 0 -9  0  4 3 2
-9 -9 -9  1 2 3
 0  0  8  6 6 0
 0  0  0 -2 0 0
 0  0  1  2 4 0

We calculate the following hourglass values:

-63, -34, -9, 12, 
-10, 0, 28, 23, 
-27, -11, -2, 10, 
9, 17, 25, 18

Our highest hourglass value is from the hourglass:

0 4 3
  1
8 6 6

Note: If you have already solved the Java domain's Java 2D Array challenge, you
may wish to skip this challenge.

Function Description
Complete the function hourglassSum in the editor below. It should return an 
integer, the maximum hourglass sum in the array.

Print the largest (maximum) hourglass sum found
 */

package aa_exercises;

import java.util.ArrayList;
import java.util.Collections;

public class Array2DLoop_hourglassFindMaxSum {

	static int hourglassSum(int[][] arr) {

		int[] newArray = new int[36];
		int[] poz1 = { 0, 1, 2, 7, 12, 13, 14 };
		int[] smak = { 0, 1, 2, 3, 6, 7, 8, 9, 12, 13, 14, 15, 18, 19, 20, 21 };
		int[] resenja = new int[16];

		// reload
		int k = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				newArray[k + j] = arr[i][j];
			}
			k = k + 6;
		}

		// make sums
		int sum = 0;
		for (int f = 0; f < smak.length; f++) {
			sum = 0;
			for (int i = 0; i < newArray.length; i++) {
				for (int j = 0; j < poz1.length; j++)
					if (i == poz1[j] + smak[f]) {
						sum = sum + newArray[i];
					}
			}
			resenja[f] = sum;
		}

		// find max
		int max = -999;
		for (int i = 0; i < resenja.length; i++) {
			if (resenja[i] > max) {
				max = resenja[i];
			}
		}

		System.out.println(max);
		return max;

	}

	static int alternativeSolution(int[][] arr) {
		ArrayList<Integer> al = new ArrayList<>();
		int sum;
		for(int i=0; i<arr.length-2; i++) {
			for(int j=0; j<arr.length-2; j++) {
				sum = arr[i][j]+arr[i][j+1]+arr[i][j+2]
						+arr[i+1][j+1]
								+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
				al.add(sum);
			}
		}
		Collections.sort(al);
		int max = al.get(15);
		return max;
	}
	
	public static void main(String[] args) {

		int[][] arr = { { -1, -1, 0, -9, -2, -2 }, { -2, -1, -6, -8, -2, -5 }, { -1, -1, -1, -2, -3, -4 }, { -1, -9, -2, -4, -4, -5 },
				{ -7, -3, -3, -2, -9, -9 }, { -1, -3, -1, -2, -4, -5 } };

		System.out.println(hourglassSum(arr));
		System.out.println(alternativeSolution(arr));

	}

}
