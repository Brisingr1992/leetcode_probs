import java.util.Arrays;

public class Solution {
    public static int[] productExceptSelfBF(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;
                
                prod *= nums[j];
            }
            
            result[i] = prod;
        }
        
        return result;
    }

    public static int[] productExceptSelfCache(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        if (n == 0) return result;

        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = 1;
        right[n - 1] = 1;
        
        for (int i = 1, j = n - 2; i < n; i++, j--) {
            left[i] = left[i - 1] * nums[i - 1];
            right[j] = right[j + 1] * nums[j + 1];
        }

        for (int i = 0; i < nums.length; i++) {            
            result[i] = left[i] * right[i];
        }
        
        return result;
    }

    public static int[] productExceptSelfCacheOpt(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        if (n == 0) return result;

        int[] left = new int[n];

        left[0] = 1;        
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {            
            result[i] = left[i] * right;
            right *= nums[i];
        }
        
        return result;
    }

    public static int[] productExceptSelfFollowUp(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        if (n == 0) return result;

        result[0] = 1;        
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {            
            result[i] *= right;
            right *= nums[i];
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] t1 = new int[] {1,0};
        int[] t2 = new int[] {1,2,3,4};

        // Brute Force
        System.out.println(Arrays.toString(productExceptSelfBF(t1)));
        System.out.println(Arrays.toString(productExceptSelfBF(t2)));

        // Cache
        System.out.println(Arrays.toString(productExceptSelfCache(t1)));
        System.out.println(Arrays.toString(productExceptSelfCache(t2)));

        // Cache Optimised
        System.out.println(Arrays.toString(productExceptSelfCacheOpt(t1)));
        System.out.println(Arrays.toString(productExceptSelfCacheOpt(t2)));

        // Follow Up
        System.out.println(Arrays.toString(productExceptSelfFollowUp(t1)));
        System.out.println(Arrays.toString(productExceptSelfFollowUp(t2)));
    }
}