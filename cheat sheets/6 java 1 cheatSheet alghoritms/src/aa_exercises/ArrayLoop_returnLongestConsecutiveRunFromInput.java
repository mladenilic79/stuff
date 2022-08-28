package aa_exercises;

import java.util.Scanner;

public class ArrayLoop_returnLongestConsecutiveRunFromInput {

	public static void main(String[] args) {

		/*
		 * 1.5.5 Write a program that reads in a sequence of integers and prints both
		 * the integer that appears in a longest consecutive run and the length of that
		 * run. For example, if the input is 1 2 2 1 5 1 1 7 7 7 7 1 1, then your
		 * program should print Longest run: 4 consecutive 7s.
		 */

		Scanner scannerInt = new Scanner(System.in);

		int prevNum = 0;
		int BestNum = 0;
		int BestLen = 0;
		int CurrNum = 0;
		int CurrLen = 0;

		while (true) {
			System.out.println("Unesite broj: ");
			CurrNum = scannerInt.nextInt();

			if (CurrNum == prevNum) {
				CurrLen++;
			} else {
				CurrLen = 1;
			}

			prevNum = CurrNum;

			if (CurrLen > BestLen) {
				BestLen = CurrLen;
				BestNum = CurrNum;
			}

			if (CurrNum == 99) {
				break;
			}
		}

		scannerInt.close();

		System.out.println("best num " + BestNum + "s best length " + BestLen);

	}

}
