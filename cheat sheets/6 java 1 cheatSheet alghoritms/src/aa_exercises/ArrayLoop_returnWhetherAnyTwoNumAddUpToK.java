
/*
Good morning! Here's your coding interview problem for today.
This problem was recently asked by Google.
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
Bonus: Can you do this in one pass?
*/

package aa_exercises;

public class ArrayLoop_returnWhetherAnyTwoNumAddUpToK {
	
	public boolean provera(int[] array, int k) {
		loop:
		for (int i=0; i<array.length; i++) {
			for (int j=i+1; j<array.length; j++) {
				if(array[i]+array[j]==k) {
					System.out.println(array[i] + " i " + array[j] + " jednako " + k);
					return true;
				} else {
					System.out.println(array[i] + " i " + array[j] + " nije jednako " + k);
				}
				
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		int[] array = {15, 10, 3, 7};
		int k = 17;
		
		ArrayLoop_returnWhetherAnyTwoNumAddUpToK exercise = new ArrayLoop_returnWhetherAnyTwoNumAddUpToK();
		exercise.provera(array, k);
		
	}

}
