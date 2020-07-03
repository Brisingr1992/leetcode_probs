import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static int[] dailyTemperatures(int[] T) {
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < T.length; i++) {
            while (!dq.isEmpty() && T[dq.peekLast()] < T[i]) {
                int idx = dq.pollLast();
                T[idx] = i - idx;
            }
            
            dq.add(i);
        }
        
        while (!dq.isEmpty()) {
            T[dq.pollLast()] = 0;
        }
        
        return T;
    }

    public static void main(String[] args) {
        int[] ans = dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ans));
    }
}