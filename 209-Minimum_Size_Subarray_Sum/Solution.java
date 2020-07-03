import java.util.Arrays;
import java.util.function.Predicate;

public class Solution {
    public static int minSubArrayLen(int[] nums, int s) {
        int result = nums.length, sum = 0, window = 0, totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            totalSum += nums[i];
            while (sum >= s) {
                result = Math.min(i - window + 1, result);
                sum -= nums[window++];
            }            
        }

        return totalSum >= s ? result : 0;
    }

    public static int minSubArrayLenBF(int[] nums, int s) {
        int result = nums.length;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    result = Math.min(result, j - i + 1);
                    break;
                }
            }   
        }

        return result;
    }

    public static int minSubArrayLenBS(int[] nums, int s) {
        int result = nums.length;
        int[] prefixSums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }
        
        for (int i = 0; i < nums.length; i++) {
            int key = prefixSums[i] + s;
            int idx = Arrays.binarySearch(prefixSums, i + 1, nums.length, key);
            
            if (idx < 0) idx = -(idx + 1);
            if (prefixSums[idx] < key) continue;
            result = Math.min(result, idx - i);
        }

        return prefixSums[nums.length] >= s ? result : 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,3,1,2,4,3};

        System.out.println(minSubArrayLenBF(nums, 7));
        System.out.println(minSubArrayLenBS(nums, 7));
        System.out.println(minSubArrayLen(nums, 7));

    }
}