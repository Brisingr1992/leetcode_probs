import java.util.*;

public class Solution {
    public static int[] avoidFloodList(int[] rains) {
        int[] result = new int[rains.length];
        Map<Integer, Integer> filledLakes = new HashMap();
        List<Integer> dryDays = new ArrayList();
        
        for (int i= 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                result[i] = 1;
            } else {
                if (filledLakes.containsKey(rains[i])) {
                    int rainDay = filledLakes.get(rains[i]);
                    int idx = ceiling(dryDays, rainDay);
                    
                    if (idx == -1 || dryDays.get(idx) <= rainDay) return new int[0];

                    result[dryDays.get(idx)] = rains[i];
                    filledLakes.remove(rains[i]);
                    dryDays.remove(idx);
                }
                
                result[i] = -1;
                filledLakes.put(rains[i], i);
            }
        }
        
        return result;
    }
    
    private static int ceiling(List<Integer> days, int key) {
        int lo = 0, hi = days.size() - 1, prev = -1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (days.get(mid) > key) {
                prev = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return prev;
    }
    public static int[] avoidFlood(int[] rains) {
        int[] result = new int[rains.length];
        Map<Integer, Integer> filledLakes = new HashMap();
        TreeSet<Integer> dryDays = new TreeSet();
        
        for (int i= 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                result[i] = 1;
            } else {
                if (filledLakes.containsKey(rains[i])) {
                    int rainDay = filledLakes.get(rains[i]);
                    Integer idx = dryDays.ceiling(rainDay);
                    
                    if (idx != null && idx > rainDay) {
                        result[idx] = rains[i];
                        filledLakes.remove(rains[i]);
                        dryDays.remove(idx);
                    } else {
                        return new int[0];
                    }
                }
                
                result[i] = -1;
                filledLakes.put(rains[i], i);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {1,2,3,4};
        int[] arr2 = new int[] {1,2,0,0,2,1};
        int[] arr3 = new int[] {1,2,0,1,2};
        int[] arr4 = new int[] {69,0,0,0,69};
        int[] arr5 = new int[] {10,20,20};

        // Using List + BinarySearch
        System.out.println(Arrays.toString(avoidFloodList(arr1)));
        System.out.println(Arrays.toString(avoidFloodList(arr2)));
        System.out.println(Arrays.toString(avoidFloodList(arr3)));
        System.out.println(Arrays.toString(avoidFloodList(arr4)));
        System.out.println(Arrays.toString(avoidFloodList(arr5)));

        // Using TreeSet
        System.out.println(Arrays.toString(avoidFlood(arr1)));
        System.out.println(Arrays.toString(avoidFlood(arr2)));
        System.out.println(Arrays.toString(avoidFlood(arr3)));
        System.out.println(Arrays.toString(avoidFlood(arr4)));
        System.out.println(Arrays.toString(avoidFlood(arr5)));
    }
}