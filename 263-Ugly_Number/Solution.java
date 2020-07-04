public class Solution {
    public static boolean isUgly(int num) {
        while (num > 1 && num % 2 == 0) num /= 2;
        while (num > 1 && num % 3 == 0) num /= 3;
        while (num > 1 && num % 5 == 0) num /= 5;
        
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(6));
        System.out.println(isUgly(8));
        System.out.println(isUgly(14));
        System.out.println(isUgly(Integer.MIN_VALUE));
    }
}