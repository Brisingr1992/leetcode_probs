public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int[] memo = new int[128];
        
        int windowStart = 0, result = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char ch = s.charAt(windowEnd);
            memo[ch]++;

            while (memo[ch] > 1) {
                memo[s.charAt(windowStart)]--;
                windowStart++;
            }
            
            result = Math.max(result, windowEnd - windowStart + 1);
        }
        
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}