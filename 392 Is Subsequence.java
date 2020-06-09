class Solution {
    // two pointers
    // 当然也可以用DP去求longest common subsequence, 判断长度是否和s一样
    public boolean isSubsequence(String s, String t) {
        int sp = 0, tp = 0;
        while (sp < s.length() && tp < t.length()) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
            }
            tp++;
        }
        
        return sp == s.length();
    }
}