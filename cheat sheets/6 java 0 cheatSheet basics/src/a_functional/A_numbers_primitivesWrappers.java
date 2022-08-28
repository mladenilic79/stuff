
package a_functional;

public class A_numbers_primitivesWrappers {
    
    public static void main(String[] args) {
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< number systems >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // number 10 in different number systems
        int xxx = 10;   // deca
        int yyy = 010;  // octal
        int zzz = 0x10; // hexa
        int qqq = 0b10; // binary
        
        // number 333 in different number systems
        System.out.println(333);    // deca
        System.out.println(0515);   // octal
        System.out.println(0x14d);  // hexa
        System.out.println(0b101001101);    // binary
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< primitives & wrappers >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        /*
        default values and wrapper classes (reference types) of primitive types:
        byte        0           Byte        -128 - 127
        short       0           Short       -32768 - 32767
        int         0           Inteeger    -2147483648 - 2147483647
        long        0L          Long        9223372036854775807L -
                                            -9223372036854775808L
        float       0.0f        Float       precise to 6 decimal places
        double      0.0d        Double      precise to 15 decimal places
        boolean     false       Boolean     true/false
        char        '\u0000'    Character
        A char will accept a number or a character surrounded by apostrophes
        Character Code for A is 65 Minimum value 0 Maximum value 65535
        They represents UTF16 code
         */
        
        // chars can also contain escaped characters
        char backSpace = '\b';
        char formFeed = '\f';
        char lineFeed = '\n';
        char carriageReturn = '\r';
        char horizontalTab = '\t';
        char doubleQuote = '\"';
        char singleQuote = '\'';
        char backSlash = '\\';
    }
}
