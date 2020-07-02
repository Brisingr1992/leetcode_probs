public class Solution {
    public static boolean isValidBF(String S) {
        String V = "abc";
        while (S.contains(V)) {
            S = S.replace(V, "");
        }
        
        return S.length() == 0;
    }

    public static boolean isValidStack(String S) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'c') {
                int len = str.length();
                if (len >= 2 && str.charAt(len - 1) == 'b' && str.charAt(len - 2) == 'a') {
                    str.setLength(len - 2);
                    continue;
                }
            }

            str.append(S.charAt(i));    
        }

        return str.length() == 0;        
    }

    public static void main(String[] args) {
        String a = "aabcbc", b = "abcabcababcc", c = "abccba", d = "cababc";

        // Brute Force
        System.out.println(a + ": " + isValidBF(a));
        System.out.println(b + ": " + isValidBF(b));
        System.out.println(c + ": " + isValidBF(c));
        System.out.println(d + ": " + isValidBF(d));

        // Using Stack
        System.out.println(a + ": " + isValidStack(a));
        System.out.println(b + ": " + isValidStack(b));
        System.out.println(c + ": " + isValidStack(c));
        System.out.println(d + ": " + isValidStack(d));
    }
}