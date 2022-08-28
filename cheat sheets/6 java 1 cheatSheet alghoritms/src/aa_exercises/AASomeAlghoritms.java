package aa_exercises;

public class AASomeAlghoritms {

	public static void main(String[] args) {

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// fing array size and init new array for reload @@@@@@@@@@@@@@@@@@@@@@@
		int[][] perai = { { 1, 3, 8 }, { 5, 1, 7 }, { 5, 2, 6 } };
		int arraySize = 0;
		for (int i = 0; i < perai.length; i++) {
			for (int j = 0; j < perai[i].length; j++) {
				arraySize++;
			}
		}
		int[] finalArray = new int[arraySize];

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// reload two dimensional array into one dimensional array @@@@@@@@@@@@@
		int[][] peral = { { 1, 3, 8 }, { 5, 1, 7 }, { 5, 2, 6 } };
		int[] newArray = new int[9];
		int k = 0;
		for (int i = 0; i < peral.length; i++) {
			for (int j = 0; j < peral[i].length; j++) {
				newArray[k + j] = peral[i][j];
			}
			k = k + 6;
		}

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// infinite array/string looping @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		String s = "abcde";
		// total planed loops;
		int n = 50;
		// current loops;
		int m = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// add to current loops
			m++;
			// when current equals planned break
			if (n == m) {
				break;
			}
			// reset counter
			if (i == s.length() - 1) {
				i = -1;
			}
		}

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// rotating elements in array to the left @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		int[] arr = { 1, 2, 3, 4, 5 };
		int lr = 2;
		for (int i = 0; i < lr; i++) {
			int temp = arr[0];
			for (int j = 0; j < arr.length - 1; j++) {
				arr[j] = arr[j + 1];
			}
			arr[arr.length - 1] = temp;
		}

		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// reverse elements in one dimensional array @@@@@@@@@@@@@@@@@@@@@@@@@@@

		int[] brojevi = { 1, 3, 6, 2, 7 };
		int n2 = brojevi.length;
		for (int i = 0; i < n2 / 2; i++) {
			int temp = brojevi[n2 - i - 1];
			brojevi[n2 - i - 1] = brojevi[i];
			brojevi[i] = temp;
		}

	}
}
