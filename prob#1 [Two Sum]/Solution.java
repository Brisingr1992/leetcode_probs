import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j}; 
                }
            }
        }

        return new int[] {-1, -1};
    }

    static int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        System.out.println(Arrays.toString(nums));

        System.out.println(Arrays.toString(twoSum(nums, 9))); // brute force
        System.out.println(Arrays.toString(twoSumMap(nums, 9))); // One pass Map
    }
}