package aa_exercises;

public class AARecursionBasics {
	
    // basic recursive function
    public static int factorial(int n){
        if(n<=1) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
    
    // top down dynamic programming
    private static long[] f = new long[92];
    public static long fibonacci1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        // return cached value (if previously computed)
        if (f[n] > 0) return f[n];
        // compute and cache value
        f[n] = fibonacci1(n-1) + fibonacci1(n-2);
        return f[n];
    }
    public static void main1(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int i = 1; i <= n; i++)
            System.out.println(i + ": " + fibonacci1(i));
    }
    
    // bottom up dynamic programming
    public static long fibonacci2(int n) {
        long[] f = new long[n+1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++)
            f[i] = f[i-1] + f[i-2];
        return f[n];
    }
    public static void main2(String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int i = 1; i <= n; i++)
            System.out.println(i + ": " + fibonacci2(i));
    }

}
