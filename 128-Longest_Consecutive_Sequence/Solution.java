import java.util.*;
public class Solution {
    public static int longestConsecutivePQ(int[] nums) {
        if (nums.length == 0) return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for (int x: nums) minHeap.add(x);
        
        int result = 1;
        while (!minHeap.isEmpty()) {
            int currSeq = 1;
            int currElem = minHeap.poll();
            while (!minHeap.isEmpty()) {
                if (minHeap.peek() == currElem + 1) {
                    currElem = minHeap.poll();
                    currSeq++;
                } else if (minHeap.peek() == currElem) {
                    minHeap.poll();
                } else {
                    break;
                }
            }
            
            result = Math.max(result, currSeq);
        }
        
        return result;
    }

    public static int longestConsecutiveSet(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int x: nums) set.add(x);
        
        int result = 1;
        for (int key: set) {
            if (!set.contains(key - 1)) {
                int curr = key + 1, currSeq = 1;
                while (set.contains(curr)) {
                    curr++;
                    currSeq++;
                }
                
                result = Math.max(result, currSeq);
            }
        }
        
        return result;
    }

    private static int[] ids, sz;
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        ids = new int[nums.length];
        sz = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ids[i] = i;
            sz[i] = 1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) continue;
            
            if (map.containsKey(nums[i] - 1)) {
                union(i, map.get(nums[i] - 1));
            }
            
            if (map.containsKey(nums[i] + 1)) {
                union(i, map.get(nums[i] + 1));
            }
            map.put(nums[i], i);
        }
        
        int max = 1;
        for (int x: sz) {
            max = Math.max(max, x);
        }
        
        return max;
    }
    
    private static int root(int i) {
        while (i != ids[i]) {
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        
        return i;
    }
    
    private static void union(int p, int q) {
        int proot = root(p);
        int qroot = root(q);
        
        if (proot == qroot) return;
        
        if (sz[proot] >= sz[qroot]) {
            ids[qroot] = proot;
            sz[proot] += sz[qroot];
        } else {
            ids[proot] = qroot;
            sz[qroot] += sz[proot];
        }
    }
    public static void main(String[] args) {
        int[] t1 = new int[] {100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutivePQ(t1));
        System.out.println(longestConsecutiveSet(t1));
        System.out.println(longestConsecutive(t1));
    }
}