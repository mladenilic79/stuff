
/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the 
number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 
'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not 
allowed.
 */

package aa_exercises;

import java.util.TreeMap;

public class HashMapRecursion_numOfWaysToDecodeMessage {

	public static int counter = 0;

	public static TreeMap<String, String> testData() {

		TreeMap<String, String> hm = new TreeMap<>();

		hm.put("a", "1");
		hm.put("b", "2");
		hm.put("c", "3");
		hm.put("d", "4");
		hm.put("e", "5");
		hm.put("f", "6");
		hm.put("g", "7");
		hm.put("h", "8");
		hm.put("i", "9");
		hm.put("j", "10");
		hm.put("k", "11");
		hm.put("l", "12");
		hm.put("m", "13");
		hm.put("n", "14");
		hm.put("o", "15");
		hm.put("p", "16");
		hm.put("q", "17");
		hm.put("r", "18");
		hm.put("s", "19");
		hm.put("t", "20");
		hm.put("u", "21");
		hm.put("v", "22");
		hm.put("w", "23");
		hm.put("x", "24");
		hm.put("y", "25");
		hm.put("z", "26");

		return hm;

	}

	/*
	// uncomplete
	public static String solution2(TreeMap<String, String> tm, String message, String pros) {
		for (Map.Entry<String, String> entry : tm.entrySet()) {
			String i = entry.getKey();
			String j = entry.getValue();
			System.out.println("prolaz " + i + " " + j);//////////////////
			String temp = pros + j;
			System.out.println(temp);/////////////////////////////////////
			System.out.println(message.substring(0, temp.length()));//////
			if (temp.equals(message.substring(0, temp.length()))) {
				if (temp.length() == message.length()) {
					counter++;
					return temp;
				} else {
					return solution2(tm, message, temp);
				}
			}
		}
		return null;
	}
	*/

	public static int NumberOfWaysToDecode(String message, int index) {
		if (index == message.length()) {
			return 1;
		}

		int waysToDecode = 0;

		int currentNumber = (int)message.charAt(index);

		if (currentNumber > 0) {
			waysToDecode += NumberOfWaysToDecode(message, index + 1);
		}

		if (index < message.length() - 1) {
			currentNumber = Integer.parseInt(message.substring(index, index + 2));

			if (currentNumber < 27) {
				waysToDecode += NumberOfWaysToDecode(message, index + 2);
			}
		}

		return waysToDecode;
	}

	public static void main(String[] args) {

		TreeMap<String, String> hm = testData();
		String message = "222";
		
//		String temp = "";
//		solution2(hm, message, temp);
//		System.out.println(counter);
		
		int result = NumberOfWaysToDecode(message, 0);
		System.out.println(result);

	}

}
