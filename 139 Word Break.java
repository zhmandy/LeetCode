class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null) return false;
        Set<String> set = new HashSet<>();
        for (String string : wordDict) {
            set.add(string);
        }
        
        // dp[i] = true if substring(0, i) is within the dict
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i; j > 0; j--) {
                String sub = s.substring(i - j, i);
                if (set.contains(sub) && dp[i - j] == true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}