public class Solution {
    public static double myPowBF(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1/x;
            N = -N;
        }

        double res = 1.0;
        for (long i = N; i > 0; i--) {
            res *= x;
        }
        return res;
    }

    public static double myPowRec(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1/x;
            N = -N;
        }
        
        return fastPow(x, n);
    }
    
    private static double fastPow(double x, int n) {
        if (n == 0) return 1;
        
        double res = fastPow(x, n / 2);
        if (n % 2 == 0) {
            res *= res;
        } else {
            res *= res * x;
        }
        
        return res;
    }

    public static double myPowIterative(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1/x;
            N = -N;
        }

        double res = 1, curr = x;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                res *= curr;
            }

            curr *= curr;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPowBF(2, 10));
        System.out.println(myPowBF(2, Integer.MIN_VALUE));
        System.out.println(myPowBF(1.2, 10));

        System.out.println(myPowRec(2, 10));
        System.out.println(myPowRec(2, Integer.MIN_VALUE));
        System.out.println(myPowRec(1.2, 10));

        System.out.println(myPowIterative(2, 10));
        System.out.println(myPowIterative(2, Integer.MIN_VALUE));
        System.out.println(myPowIterative(1.2, 10));
    }
}