package aa_exercises;

import java.util.Scanner;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class ArrayLoop_returnLongestConsecutiveRunFromInput2 {

	public static void main(String[] args) {

		/*
		 * 1.5.5 Write a program that reads in a sequence of integers and prints both
		 * the integer that appears in a longest consecutive run and the length of that
		 * run. For example, if the input is 1 2 2 1 5 1 1 7 7 7 7 1 1, then your
		 * program should print Longest run: 4 consecutive 7s.
		 */


		// degenerate case with no input integers
        if (StdIn.isEmpty()) {
            StdOut.println("no longest consecutive run");
            return;
        }

        int prev = StdIn.readInt();
        int count = 1;
        int best      = prev;
        int bestCount = count;

        while (!StdIn.isEmpty()) {
            // read in the next value
            int current = StdIn.readInt();

            // update current run
            if (current == prev) count++;
            else {
                prev = current;
                count = 1;
            }

            // update champion values
            if (count > bestCount) {
                bestCount = count;
                best      = current;
            }
        }
      
        // output
        StdOut.println("Longest run: " + bestCount + " consecutive " + best + "s");
		
		
	}

}
