
/*
John works at a clothing store. He has a large pile of socks that he must pair 
by color for sale. Given an array of integers representing the color of each 
sock, determine how many pairs of socks with matching colors there are.

For example, there are socks with colors. There is one pair of color and one of 
color. There are three odd socks left, one of each color. number of pairs is.
*/

package aa_exercises;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayLoop_howManyPairsOfSocksByColor {
	
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

    	ArrayList<Integer> arrayList = new ArrayList<>();
    	
    	loop:
        for(int i=0; i<ar.length; i++) {
        	System.out.println();
        	System.out.println("glavni prolaz broj " + i);
        	if(arrayList.contains(i)) {
        		System.out.println("vec sadrzi " + i);
        		continue;
        	}
        	for(int j=i+1; j<ar.length; j++) {
        		if(arrayList.contains(j)) {
        			System.out.println("vec sadrzi " + j);
        			continue;
        		}
        		if(ar[i]==ar[j]) {
        			System.out.println("nasli resenje indexi " + i + " " + j);
        			arrayList.add(i);
        			arrayList.add(j);
        			continue loop;
        		}
        	}
        	System.out.println("kraj glavnog prolaza broj " + i);
        	System.out.println();
        }
        System.out.println();
        int m = arrayList.size();
        System.out.println("ukupno carapa" + m);
        System.out.println("upola carapa" + m/2);
		return m/2;

    }

    public static void main(String[] args) throws IOException {

    	int n = 7;
        int[] ar = {1,1,1,1,1,1,1};

        int result = sockMerchant(n, ar);
        System.out.println(result);

    }
}
