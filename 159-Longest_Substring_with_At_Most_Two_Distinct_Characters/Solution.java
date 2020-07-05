import java.util.Map;
import java.util.HashMap;

public class Solution {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        int windowStart = 0, result = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char ch = s.charAt(windowEnd);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            while (map.size() > 2) {
                char prev = s.charAt(windowStart++);
                map.put(prev, map.get(prev) - 1);
                if (map.get(prev) == 0) {
                    map.remove(prev);
                }
            }
            
            result = Math.max(result, windowEnd - windowStart + 1);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }
}