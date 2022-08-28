
package f_variousClasses;

import java.util.Random;

public class Random_vc {
    
    public static void main(String[] args) {
        
        // random class
        Random random = new Random();
        
        // receive next number
        int x = random.nextInt();
        
        // generate number from min to max
        int min = 5;
        int max = 10;
        int y = random.nextInt(max - min + 1) + min;
        
        System.out.println("executed");
    }
}
