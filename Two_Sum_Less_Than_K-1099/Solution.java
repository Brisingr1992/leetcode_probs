import java.util.Arrays;

public class Solution {
    static int twoSumLessThanK(int[] A, int K) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] + A[j] < K) {
                    result = Math.max(result, A[i] + A[j]);
                }
            }
        }
        
        return result > 0 ? result : -1;
    }

    static int twoSumLessThanKSort(int[] A, int K) {
        int result = 0;
        
        Arrays.sort(A);
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] + A[j] >= K) {
                j--;
            } else {
                result = Math.max(result, A[i] + A[j]);
                i++;
            }
        }
        
        return result > 0 ? result : -1;
    }

    static int twoSumLessThanKCountingSort(int[] A, int K) {
        int result = -1, lo = 1001, hi = 0;
        int[] count = new int[1001];
        for (int x: A) {
            lo = Math.min(lo, x);
            hi = Math.max(hi, x);
            count[x]++;
        }
        
        while (lo < hi) {
            if (count[lo] == 0) { lo++; continue; }
            if (count[hi] == 0) { hi--; continue; }

            if (lo + hi >= K) {
                hi--;
            } else {
                result = Math.max(result, lo + hi);
                lo++;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] A1 = new int[] {34,23,1,24,75,33,54,8};
        int[] A2 = new int[] {10,20,30};

        int k1 = 60, k2 = 15;
        
        System.out.println("Array1: " + Arrays.toString(A1) + " K1: " + k1);
        System.out.println("Array2: " + Arrays.toString(A2) + " K2: " + k2);

        System.out.println(twoSumLessThanK(A1, k1)); // brute force
        System.out.println(twoSumLessThanK(A2, k2)); // brute force

        System.out.println(twoSumLessThanKSort(A1, k1)); // Two Pointers 
        System.out.println(twoSumLessThanKSort(A2, k2)); // Two Pointers

        System.out.println(twoSumLessThanKCountingSort(A1, k1)); // Counting Sort
        System.out.println(twoSumLessThanKCountingSort(A2, k2)); // Counting Sort
    }
}