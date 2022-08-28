
/*
Emma is playing a new mobile game that starts with consecutively numbered 
clouds. Some of the clouds are thunderheads and others are cumulus. She can jump 
on any cumulus cloud having a number that is equal to the number of the current 
cloud plus or. She must avoid the thunderheads. Determine the minimum number of 
jumps it will take Emma to jump from her starting postion to the last cloud. It 
is always possible to win the game. For each game, Emma will get an array of 
clouds numbered if they are safe or if they must be avoided. For example, 
indexed from. The number on each cloud is its index in the list so she must 
avoid the clouds at indexes and. She could follow the following two paths: or.
The first path takes jumps while the second takes.
 */

package aa_exercises;

public class ArrayLoop_jumpingCloudsDetermineMinNumOfJumps {

	static int jumpingOnClouds(int[] c) {

		int putanja = 0;
		
		for(int i=0; i<c.length; i++) {
			if(i+1==c.length) {
				break;
			}
			if(i+2==c.length) {
				putanja++;
				System.out.println("dodaj zadnju putanju");
				break;
			}
			if(i+3==c.length) {
				putanja++;
				System.out.println("dodaj zadnju putanju");
				break;
			}
			if(c[i+2]!=1) {
				System.out.println("pre update i, i " + i + ", putanja " + putanja);
				i++;
				System.out.println("posle update i, i " + i + ", putanja " + putanja);
			}
			System.out.println("pre update putanje, i " + i + ", putanja " + putanja);
			putanja++;
			System.out.println("posle update putanje, i " + i + ", putanja " + putanja);
			System.out.println();
		}
		return putanja;
    }

	public static void main(String[] args) {
		
		int[] c = {0,1,0,1,0,0,1,0,1,0};
		
		int resenje = jumpingOnClouds(c);
		
		System.out.println("duzina " + c.length);
		System.out.println("resenje " + resenje);

	}

}
