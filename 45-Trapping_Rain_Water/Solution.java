public class Solution {
    public static int trapBF(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = 0, rightMax = 0;
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            
            int min = Math.min(leftMax, rightMax);
            if (min > height[i]) result += min - height[i];
        }
        
        return result;
    }

    public static int trapCache(int[] height) {
        int result = 0, n = height.length;
        if (n == 0) return 0;
        
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        int left = height[0], right = height[n - 1];
        for (int i = 1, j = n - 2; i < height.length; i++, j--) {
            leftMax[i] = left;
            rightMax[j] = right;
            left = Math.max(left, height[i]);
            right = Math.max(right, height[j]);
        }
        
        for (int i = 0; i < height.length; i++) {            
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > height[i]) result += min - height[i];
        }
        
        return result;
    }

    public static int trap(int[] height) {
        return trapRecursive(height, 0, height.length - 1, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
    
    private static int trapRecursive(int[] height, int lo, int hi, int lMax, int rMax) {
        if (lo > hi) return 0;
        if (lMax != Integer.MIN_VALUE && rMax != Integer.MIN_VALUE) {
            int min = Math.min(lMax, rMax), total = 0;
            for (int i = lo; i <= hi; i++) {
                total += (min - height[i]);
            }
            return total;
        }
        
        int max = Integer.MIN_VALUE, idx = -1;
        for (int i = lo; i <= hi; i++) {
            if (height[i] > max) {
                max = height[i];
                idx = i;
            }
        }
        
        int left = trapRecursive(height, lo, idx - 1, lMax, height[idx]);
        int right = trapRecursive(height, idx + 1, hi, height[idx], rMax);
        
        return left + right;
    }

    public static int trapLowerEnvelope(int[] height) {
        int result = 0, lMax = 0, rMax = 0;
        int i = 0, j = height.length - 1;
        
        while (i <= j) {
            lMax = Math.max(lMax, height[i]);
            rMax = Math.max(rMax, height[j]);
            
            if (lMax <= rMax) {
                result += (lMax - height[i]);
                i++;
            } else {
                result += (rMax - height[j]);
                j--;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] t1 = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] t2 = new int[] {4,2,3};
        int[] t3 = new int[] {0,7,1,4,6};
        // Brute Force
        System.out.println(trapBF(t1));
        System.out.println(trapBF(t2));
        System.out.println(trapBF(t3));

        // Recursive
        System.out.println(trap(t1));
        System.out.println(trap(t2));
        System.out.println(trap(t3));

        // Cache
        System.out.println(trapCache(t1));
        System.out.println(trapCache(t2));
        System.out.println(trapCache(t3));

        // Lower Enveloper / Two Pointers
        System.out.println(trapLowerEnvelope(t1));
        System.out.println(trapLowerEnvelope(t2));
        System.out.println(trapLowerEnvelope(t3));
    }
}