import java.util.Arrays;

public class Solution {
    public static int triangleNumberBF(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (validTriangle(nums[i], nums[j], nums[k])) count++;
                }
            }
        }
        
        return count;
    }
    
    private static boolean validTriangle(int a, int b, int c) {
        return a + b > c && b + c > a && a + c > b;
    }

    public static int triangleNumberBinarySearch(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int lo = j + 1, hi = nums.length - 1, key = nums[i] + nums[j];
                while (lo <= hi) {
                    int mid = (lo + hi) / 2;
                    
                    if (nums[mid] >= key) hi = mid - 1;
                    else lo = mid + 1;
                }
                
                count += (lo - j - 1);
            }
        }
        
        return count;
    }

    public static int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                
                count += (k - j - 1);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] t1 = new int[] {2,2,3,4};
        int[] t2 = new int[] {2,3,4,3,2,4,5,6,6,4,3,2,1,3,4,5,5,3,2,2};

        // Brute Force
        System.out.println(triangleNumberBF(t1));
        System.out.println(triangleNumberBF(t2));

        // Binary Search
        System.out.println(triangleNumberBinarySearch(t1));
        System.out.println(triangleNumberBinarySearch(t2));

        // Linear optimisation
        System.out.println(triangleNumber(t1));
        System.out.println(triangleNumber(t2));
    }
}