import java.util.Map;
import java.util.HashMap;

class TwoSumMap {
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSumMap() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int key: map.keySet()) {
            int comp = value - key;
            if (comp != key) {
                if (map.containsKey(comp)) return true;
            } else {
                if (map.get(comp) > 1) return true;
            }
        } 
        
        return false;
    }
}
