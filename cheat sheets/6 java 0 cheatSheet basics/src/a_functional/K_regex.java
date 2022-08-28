
package a_functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class K_regex {
    
    public static void main(String[] args) {

        Scanner scString = new Scanner(System.in);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< theory >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        /*
        \ ............................. escape character for special chars
        . ^ * + ? { } [ ] \ | ( ) ..... special characters
        [abc] ......................... list of chars to insert
        [0-9] ......................... range of chars to insert
        [^a-g] ........................ range of chars not to insert
        . ............................. wildcard for anything but newline
        \s or [\t\n\xOB\f\r] .......... any white space
        \S or [^\s] ................... any non white space
        \d or [0-9] ................... any digits 0-9
        \D [^0-9] ..................... anything not a number
        \w or [A-Za-z0-9] ............. any word type character A-Z, a-z, 0-9, _
        \W or [^\w] ................... any non word character
        {n,m} ..... proceeds must occur between n and m times
        {n} ....... proceeds must occur n times
        {n,} ...... proceeds must occur at least n times
        + ......... proceeds must occur one or more times
        * ......... proceeds must occurs zero or more times
        ? ......... 0 or 1 of what proceeds it
        ^ ......... beginning of string
        $ ......... end of string
        | ......... OR clause
        () ........ for groupings
        */
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< basics >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // insert pattern to check
        Pattern p = Pattern.compile("bong");
        Pattern p2 = Pattern.compile("bong", Pattern.CASE_INSENSITIVE);
        // insert string to check
        Matcher m = p.matcher("bing bang bong bung");
        // find matches returns boolean
        System.out.println("String contains word: " + m.find());
        // You can get the starting and ending indexs of a match
        System.out.println( "Start Index: " + m.start());
        System.out.println( "Start Index: " + m.end());
        // replace found
        System.out.println(m.replaceAll("HELLO"));
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< input while not correct >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        System.out.println("unesi mail");
        // loop until insert right
        while (true) {
            // input string/mail to check
            String mail = scString.nextLine();
            // input pattern to check
            Pattern p3 
                    = Pattern.compile(
                            "[a-zA-Z0-9_-]{2,20}@[a-zA-Z]{1,10}.[a-zA-Z]{2,3}");
            // check if there is a pattern in string
            Matcher m3 = p3.matcher(mail);
            if (m3.find()) {
                break;
            }
        }
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< match through array list >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        System.out.println("unesi recenice za proveru");
        List<String> sentences = new ArrayList<>();
        sentences.add("prva recenica");
        sentences.add("druga recenica");
        Pattern p5 = Pattern.compile("rec");
        for (String s : sentences) {
            Matcher m5 = p5.matcher(s);
            if (m5.find()) {
                System.out.println(s);
            } else {
                System.out.println("nema");
            }
        }
    }
}
