
/*
Gary is an avid hiker. He tracks his hikes meticulously, paying close attention 
to small details like topography. During his last hike he took exactly steps. 
For every step he took, he noted if it was an uphill, , or a downhill, step. 
Gary's hikes start and end at sea level and each step up or down represents a
unit change in altitude. We define the following terms:

    A mountain is a sequence of consecutive steps above sea level, starting with 
    a step up from sea level and ending with a step down to sea level.
    
    A valley is a sequence of consecutive steps below sea level, starting with a 
    step down from sea level and ending with a step up to sea level.

Given Gary's sequence of up and down steps during his last hike, find and print 
the number of valleys he walked through.

For example, if Gary's path is he first enters a valley units deep. Then he 
climbs out an up onto a mountain units high. Finally, he returns to sea level 
and ends his hike. 
 */

package aa_exercises;

public class ArrayLoop_countCrossingsOfTheSeaLevel {

	static int countingValleys(int n, String s) {

		int[] array = new int[s.length()];

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'D') {
				array[i] = -1;
			} else {
				array[i] = 1;
			}
		}

		int doline = 0;
		int temp = 0;
		int level = 0;

		for (int i = 0; i < array.length; i++) {

			temp = level;
			level += array[i];

			if (level == 0) {
				if (temp < 0) {
					doline++;
				}
			}

		}
		return doline;
	}

	public static void main(String[] args) {

		// putanja
		String s = "DDUUUUDD";

		// steps
		int n = s.length();

		int doline = countingValleys(n, s);

		System.out.println(doline);

	}
}
