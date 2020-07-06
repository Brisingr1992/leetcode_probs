import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1, k = nums.length - 1;
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    j++; k--;

                    while (j < nums.length && nums[j] == nums[j - 1]) j++;
                    while (k >= 0 && nums[k] == nums[k + 1]) k--;
                }
            }
            
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }
        
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = threeSum(new int[] {-1, 0, 1, 2, -1, -4});
        for (List<Integer> l: result) {
            System.out.println(l);
        }
    }
}