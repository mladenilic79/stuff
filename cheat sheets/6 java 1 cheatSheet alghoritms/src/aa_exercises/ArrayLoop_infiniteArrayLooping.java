
// infinite string

package aa_exercises;

public class ArrayLoop_infiniteArrayLooping {

	static long repeatedString(String s, long n) {

		// how much in one string
		int howmuch = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'a') {
				howmuch++;
			}
		}
		
		int stringLen = s.length();
		long celih = n/stringLen;
		long razlomljeno = n%stringLen;
		
		// how much in part of string
		int howmuchpart = 0;
		for(int i = 0; i<n%stringLen; i++) {
			char c = s.charAt(i);
			if(c=='a') {
				howmuchpart++;
			}
		}
		
		long total = (howmuch*celih)+howmuchpart;
		return total;

	}

	public static void main(String[] args) {

		String s = "a";
		long n = 1000000000000L;

		long howmuch = repeatedString(s, n);
		System.out.println(howmuch);
		
//		System.out.println("celih " + 4/6);
//		System.out.println("razlom " + 4%6);

	}

}
