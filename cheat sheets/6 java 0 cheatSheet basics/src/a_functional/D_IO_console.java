
package a_functional;

import java.util.Scanner;

public class D_IO_console {
    
    public static void main(String[] args) {
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< input scanner >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // separate string & number input object
        Scanner scannerString = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);
        
        // receive string
        System.out.println("Unesite ime: ");
        String ime = scannerString.nextLine();
        
        // in case you need first character from string
        char w = ime.charAt(0);
        
        // receive number
        System.out.println("Unesite godine: ");
        int godine = scannerInt.nextInt();
        
        // close scanners at the end if needed
        scannerInt.close();
        scannerString.close();
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< input console >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        /*
        (ide-s does not have system console
        so this code will not work in ide-s)
        */
        
        // create console object
//        Console console = System.console();
        
        // check if console object exist (optional)
//        if (console == null) {
//            System.err.println("No console.");
//            System.exit(1);
//        }

        // usefull for reading login information (password expecially)
//        String login = console.readLine("Enter your login: ");
//        char[] pass = console.readPassword("Enter pass: ");

//        console.flush();
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< output >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        String string = "pera";
        int x = 7;
        double pi = 3.14159;
        
        /*
        \t tab,  , .2 decimal places, %n new line
        %[argument number][flags][width][.precision]type
        type: %s string, %d number, %.3f float, %x hexadecimal, %c character,
        	%tc date & time (pass date object),
        	%tr just the time (pass date object),
        	%tA %tB %td day of the week, month, day of the month (pass three 
        		date objects respectivelly
        format() & printf() are same
        */
        System.out.format(
                "\t resenje je: %s i %d i %.2f i %.6f%n", string, x, pi, pi);

        // printing with new line
        System.out.println("pera"); // or
        System.out.print("pera\n");
        
        // ofset blank spaces from begining of page (from the left)
        System.out.format("%" + 5 + "s\n", string);
    }
}
