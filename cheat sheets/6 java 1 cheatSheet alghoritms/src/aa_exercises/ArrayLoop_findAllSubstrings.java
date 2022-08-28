package aa_exercises;

public class ArrayLoop_findAllSubstrings {

	public static void main(String[] args) {

		/*
		 * 3.1.22 Write a program that takes a start string and a stop string as
		 * command-line arguments and prints all substrings of a given string that start
		 * with the first, end with the second, and otherwise contain neither. Note: Be
		 * especially careful of overlaps!
		 */

		String string = "perendz1ast1ost1.5cemdaendz2tidujekost2vendz3ladasrbijo"
				+ "mendz4brst3esadaitaendz5dahast4haodmendz6ahsada";

		/*
		 * end1 st1 end2 st2 end3 end4 st3 end5 st4 end6
		 */

		String start = "st";
		String end = "end";

		int startbre = 0;

		while (true) {
			int startInt = string.indexOf(start, startbre);
			int endInt = string.indexOf(end, startInt);
			String sub = string.substring(startInt, endInt + 5);
			String subtest = string.substring(startInt + 1, endInt);
			if (subtest.contains(start) || subtest.contains(end)) {

			} else {
				System.out.println(sub);
			}
			startbre = startInt + 1;
			int last = string.lastIndexOf(end);
			if (last == endInt) {
				break;
			}
		}

	}

}
