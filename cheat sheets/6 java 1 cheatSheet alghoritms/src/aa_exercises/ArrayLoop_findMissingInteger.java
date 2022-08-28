package aa_exercises;

public class ArrayLoop_findMissingInteger {

	public static void main(String[] args) {
		
		/*
		4.1.34 Finding a repeated integer. (a) Given an array of n integers from 
		1 to n with one value repeated twice and one missing, give an algorithm 
		that finds the missing integer, in linear time and constant extra 
		memory. Integer overflow is not allowed.
		*/
		
		int[] a = {2,3,3,4,5,7,1,8,9};
		int b = 1;
		
		for(int i=0; i<a.length; i++) {
			System.out.println("i " + i + ", a[i] " + a[i] + ", b " + b);
			if(a[i]==b) {
				System.out.println("duplo i " + i + ", a[i] " + a[i] + ", b " + b);
				b++;
				i=-1;
				continue;
			}else if(i==a.length-1){
				System.out.println("solution is " + b);
				break;
			}
		}

	}

}
