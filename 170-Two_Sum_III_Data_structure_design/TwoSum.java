import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TwoSum {
    List<Integer> twoSum;
    /** Initialize your data structure here. */
    public TwoSum() {
        twoSum = new ArrayList<Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        int idx = Collections.binarySearch(twoSum, number);
        if (idx < 0) idx = -(idx + 1);
        
        if (idx >= twoSum.size()) twoSum.add(number);
        else twoSum.add(idx, number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        int lo = 0, hi = twoSum.size() - 1;
                
        while (lo < hi) {
            int sum = twoSum.get(lo) + twoSum.get(hi);
            if (sum > value) {
                hi--;
            } else if (sum < value) {
                lo++;
            } else return true;
        }
        
        return false;
    }
}
