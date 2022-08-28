
package a_functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class F_flow_iteration {
    
    public static void main(String[] args) {
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< flow operators >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        /*
        Relational Operators:

        > : Greater Than
        < : Less Than
        == : Equal To
        != : Not Equal To
        >= : Greater Than Or Equal To
        <= : Less Than Or Equal To

        Logical Operators:

        ! : Converts the boolean value to its opposite form true to false
        & : Returns true if boolean value are both true
            (Always evaluates both boolean values)
        && : Returns true if boolean value are both true
            (Stops evaluating after first false)
        | : Returns true if either boolean value are true
            (Always evaluates both boolean values)
        || : Returns true if either boolean value are true
            (Stops evaluating after first true)
        ^ : Returns true if there is 1 true and 1 false boolean value
        */
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< some variables >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        int x = 5;
        int y = 6;
        String[] string = {"sima", "pera", "nesko"};
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList(string));
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< if >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        if (x==0){
            System.out.println("broj je n");
        } if (x % 3 == 0 && x % 2 == 0 || x != 4) {
            // usklicnik pravi negaciju od bilo cega
            System.out.println("broj je d");
        } else if (!true) {
            System.out.println("broj je");
        } else {
            System.out.println("broj nije");
        }
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< Conditional/Ternary Operator >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        int biggest = (x > y) ? x : y;
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< switch >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        /*
        You are not required to use the break or default statements
        The expression must be an int, short, byte, or char
        Will not work with decimal numbers or complex types (except wrappers)
        */
        char op = '+';
        switch (op) {
            case ('+'):
                System.out.println("zbir je: " + (x + y));
                break;
            case ('-'): // multiple version
            case ('*'):
                System.out.println("razlika je: " + (x - y));
                break;
            default:
                System.out.println("greska");
                break;
        }

        // switch from java 12 & 13
        // waiting for inclusion
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< for za fibonachi >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        x = 0;
        y = 1;
        int temp1;
        for (int i = 0; i<10; i++)
        {
            System.out.println(x);
            temp1 = x + y;
            x = y;
            y = temp1;
        }
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< while za faktorijel >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        x = 1;
        y = 0;
        int i = 1;
        // loops can be named
        namedLoop:
        while (i<10) {
            x = x * i;
            y = y + i;
            System.out.println("proizvod" + x);
            System.out.println("zbir" + y);
            i++;
            break namedLoop;
//            continue namedLoop;
        }
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< do while loop >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // the code between {} will execute at least once
        int k = 1;
        do {
            System.out.println(k);
            k++;
        } while (k <= 10);
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< for each >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        for(String temp2 : string){
            System.out.println(temp2);
        }
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< iterator in this example iterating over arraylist >>>>> @@@@@@@
        
        Iterator iter = stringList.iterator();
        while(iter.hasNext()){
            Object line = iter.next();
            // casting back to string
            String pera = (String)line;
        }
        /*
        userInput.hasNext() : token input (object)
        userInput.hasNextFloat() : returns true if next value entered is float
        userInput.hasNextDouble() : double input
        userInput.hasNextInt() : Integer input
        userInput.hasNextLine() : String input
        There are others for Boolean, Byte, Long, and Short

        userInput.next() : for tokens
        userInput.nextFloat() : receives user input and stores it in
        the variable if it's float
        userInput.nextDouble() : for Doubles
        userInput.nextInt() : for Integers
        userInput.nextLine() : for Strings
        There are others for Boolean, Byte, Long, and Short

        If the user enters a value of the wrong type the program crashes
        */
    }
}
