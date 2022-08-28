
/*
Good morning! Here's your coding interview problem for today.
This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i 
of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be 
[120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
*/

package aa_exercises;

public class ArrayLoop_returnArrayOfElementsThatAreProductOfAllNumExcept {
	
	public static void main(String[] args) {
		
		int[] inputArray = {1, 2, 3, 4, 5};
		int[] outputArray = new int[inputArray.length];
		
		for(int i=0; i<inputArray.length; i++) {
			int k = 1;
			for(int j=0; j<inputArray.length; j++) {
				if(i==j) { // b)
					continue;
				} else {
					k = k * inputArray[j];
				}
			}
//			k = k / inputArray[i];
			outputArray[i] = k;
		}
		
		for(int i : outputArray) {
			System.out.println(i);
		}
		
	}
	
}
