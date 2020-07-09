import java.util.*;

public class Solution {
    public static int largestRectangleAreaBF(int[] heights) {
        // Brute Force
        int largestArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int count = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < heights[i]) break;
                
                count++;
            }
            
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] < heights[i]) break;
                
                count++;
            }

            largestArea = Math.max(largestArea, heights[i] * count);
        }
        
        return largestArea;
    }

    public static int largestRectangleAreaDC(int[] heights) {
        return findAreaRecursive(heights, 0, heights.length - 1);
    }
    
    private static int findAreaRecursive(int[] nums, int lo, int hi) {
        if (lo > hi) return 0;

        int minIdx = findMinIndex(nums, lo, hi);
        int area1 = findAreaRecursive(nums, lo, minIdx - 1);
        int area2 = findAreaRecursive(nums, minIdx + 1, hi);
        
        return Math.max(area1, Math.max(area2, nums[minIdx] * (hi - lo + 1)));
    }
    
    private static int findMinIndex(int[] nums, int lo, int hi) {
        int minIdx = lo, min = nums[lo];
        for (int i = lo + 1; i <= hi; i++) {
            if (nums[i] <= min) {
                min = nums[i];
                minIdx = i;
            }
        }
        
        return minIdx;
    }
    
    public static int largestRectangleAreaCache(int[] heights) {
        int result = 0, n = heights.length;
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            // left logic => whenever you enter a bigger number update its value
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                right[stack.pop()] = i;
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            right[stack.pop()] = n;
        }
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                left[stack.pop()] = i;
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            left[stack.pop()] = -1;
        }

        for (int i = 0; i < heights.length; i++) {
            result = Math.max(result, (right[i] - left[i] - 1) * heights[i]);
        }
        
        return result;
    }

    public static int largestRectangleAreaCacheN(int[] heights) {
        int result = 0, n = heights.length;
        
        if (n == 0) return 0;
        
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = -1;
        right[n - 1] = n;
        
        for (int i = 1; i < n; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = left[p];
            }
            
            left[i] = p;
        }
        
        for (int i = n - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < n && heights[p] >= heights[i]) {
                p = right[p];
            }
            
            right[i] = p;
        }

        for (int i = 0; i < n; i++) {
            result = Math.max(result, (right[i] - left[i] - 1) * heights[i]);
        }
        
        return result;
    }

    public static int largestRectangleAreaST(int[] heights) {
        int result = 0, n = heights.length;
        
        if (n == 0) return 0;
        
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                int idx = stack.pop();
                result = Math.max(result, (i - stack.peek() - 1) * heights[idx]);
            }
            
            stack.push(i);
        }
        
        while (stack.peek() != -1) {
            int idx = stack.pop();
            result = Math.max(result, (n - stack.peek() - 1) * heights[idx]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] heights = new int[] {2, 1, 2};
        int[] heights2 = new int[] {2,1,5,6,2,3};

        // Brute Force
        System.out.println(largestRectangleAreaBF(heights));
        System.out.println(largestRectangleAreaBF(heights2));

        // Divide and Conquer
        System.out.println(largestRectangleAreaDC(heights));
        System.out.println(largestRectangleAreaDC(heights2));

        // Cache
        System.out.println(largestRectangleAreaCache(heights));
        System.out.println(largestRectangleAreaCache(heights2));

        // Cache without stack
        System.out.println(largestRectangleAreaCacheN(heights));
        System.out.println(largestRectangleAreaCacheN(heights2));

        // Using stack
        System.out.println(largestRectangleAreaST(heights));
        System.out.println(largestRectangleAreaST(heights2));
    }
}