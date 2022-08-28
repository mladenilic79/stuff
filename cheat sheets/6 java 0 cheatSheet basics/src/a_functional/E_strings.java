
package a_functional;

import java.util.stream.Stream;

public class E_strings {
    
    public static void main(String[] args) {
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< strings definition >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        /*
        A String is immutable, which means every time you change a String a new
        version is created in memory.
        */

        // Always surround Strings with quotes " " and not Apostrophes ' '
        String string1 = "I'm just a random string";

        // If you want to use quotes in a string escape it with \
        String string2 ="He said, \"I'm here\"";

        // text block from java 13
        // waiting for inclusion
        
        /*
        Other common Escape Codes
        \b : Backspace
        \f : FormFeed
        \n : Newline
        \r : CarriageReturn
        \t : HorizontalTab
        \" : Quote
        \' : Apostrophe
        \\ : Backslash
        */

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< string information >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // length() returns the number of characters in a String
        System.out.println("Length of string: " + string1.length());
        
        // checking if contains pieces of strings
        System.out.println(string1.contains("abc"));
        System.out.println(string1.endsWith("de"));
        System.out.println(string1.startsWith("pe"));
        
        // You compare strings with equals or equalsIgnoreCase
        String upperCase = "BIG";
        String lowerCase = "big";
        if(upperCase.equals(lowerCase)){
            System.out.println("They're equal");
        }
        if(upperCase.equalsIgnoreCase(lowerCase)){
            System.out.println("Same letters");
        }
        
        /*
        compareTo() & compareToIgnoreCase() returns 0 if strings are equal
        Returns a negative number if string1 comes before string2
        Returns a positive number if string1 comes after string2
        */
        System.out.println(string1.compareTo(string2));
        System.out.println(string1.compareToIgnoreCase(string2));
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< string manipulation >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // You combine Strings with + or concat
        System.out.println(string1 + " pera " + string2);
        System.out.println(string1.concat(string2));

        // You can add other data type to the string with +
        System.out.println(string1 + " " + 5);
        
        // replaces every occurrence of string with second string you provide
        System.out.println(string1.replace("abc", "xy"));

        // trim() gets rid of leading and trailing white space
        System.out.println(string1.trim());
        
        // toUpperCase() / toLowerCase() converts all letters
        System.out.println(string1.toUpperCase());
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< string index >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        // charAt returns the character in a string at index
        System.out.println("2nd Character: " + string1.charAt(1));

        // returns string starting at first through the last index provided
        System.out.println(string1.substring(1,4));

        // returns the 1st index that matches the specified string
        System.out.println(string1.indexOf("cd"));
        // optional ignore first 5 characters
        System.out.println(string1.indexOf("cd", 5));

        // returns the last index that matches the specified string
        System.out.println(string1.lastIndexOf("cd"));
        // optional ignore last 5 characters
        System.out.println(string1.lastIndexOf("cd", 5));
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< string arrays >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        /*
        toCharArray() inserts every character in the string into
        separate indexes in an array
        */
        char[] charArray = string1.toCharArray();

        /*
        You can create an array of Strings with split()
        You define how to break up the String using a delimiter
        */
        String[] letterArray = string1.split(" ");
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< streaming lines >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // from java 11, returns stream of lines from string
        Stream<String> lines = string1.lines();
        lines.forEach(System.out::println);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< string conversion >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        //You convert primitive types to a string with toString
        String broj1 = Integer.toString(5);
        /*
        Byte.toString(), Short.toString(), Long.toString(), Float.toString(),
        Double.toString(), Boolean.toString()
        */

        /*
        return string from other types (doesn't return null pointer exception
        for null value like toString() method)
        */
        String broj2 = String.valueOf(5);
        
        // You convert from String to primitives with parse
        int x = Integer.parseInt("5");
        /*
        Short.parseShort(), Byte.parseByte(), Long.parseLong(),
        Float.parseFloat(), Double.parseDouble(), Boolean.parseBoolean()
         */
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< string builder definition >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // StringBuilder has a fixed space in memory
        
        // convert string to string builder
        StringBuilder sb = new StringBuilder("A random string");

        // convert a SB to String
        String string = sb.toString();

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< string builder information, length & capacity >>>>> @@@@@@@@@@@
        
        // current capacity of the string builder
        System.out.println(sb.capacity());

        // increases the capacity for the string builder
        sb.ensureCapacity(60);

        // returns the number of characters in the sb
        System.out.println(sb.length());

        // sets new length of the characters in sb
        sb.setLength(5);

        // forces capacity to equal length of string inside
        sb.trimToSize();

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< string builder manipulations & index >>>>> @@@@@@@@@@@@@@@@@@@@
        
        /*
        StringBuilders also have the many of the same methods as Strings
        charAt(), indexOf(), lastIndexOf(), subString(),...
        */
        
        // append() adds anything to the end of a SB
        System.out.println(sb.append("again"));

        // insert() inserts at the index you provide anything
        System.out.println(sb.insert(1, "another"));
        
        // removes part of the sb from first index to the last
        System.out.println(sb.delete(15, 21));

        // deleteCharAt(index) is used to delete individual chars
        sb.deleteCharAt(0);
    }
}
