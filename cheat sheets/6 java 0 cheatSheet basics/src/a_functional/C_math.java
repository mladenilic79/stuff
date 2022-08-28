
package a_functional;

public class C_math {
    
    public static void main(String[] args) {
        
        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< math basics >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        int x = 5;
        
        // % Modulus returns the remainder of a division
        int y = x % 2;

        /*
        Shorthand way to add, subract, multiplay, divide or modulus
        to a variable and reassign the result
        */
        x += 2;
        x -= 2;
        x *= 2;
        x /= 2;
        x %= 2;

        /*
        Shorthand way to add or subtracked 1 to a variable
        after operation (postfix)
        */
        x++; // value is x, +1 is added afterwords
        x--;
        // before operation (prefix)
        ++x; // value is x+1
        --x;

        // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        // <<<<< math methods >>>>> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        
        // Returns the absolute value
        int z = Math.abs(x);

        // Returns larger or Smaller of the two (They must be same type)
        int m = Math.max(5, 7);
        int n = Math.min(5, 7);

        // Returns the square root argument
        double p = Math.sqrt(x);

        // Rounds the number provided up or down or closer
        double d = Math.ceil(5.23);
        double c = Math.floor(5.23);
        double v = Math.round(5.23);
        
        System.out.println("executed");
    }
}
