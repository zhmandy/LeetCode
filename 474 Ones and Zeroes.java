class Solution {
    // 从后往前更新dp矩阵, 只有当当前的zeros, ones数量能够满足构建字符串的时候
    // 才能够+1
    public int[] countzerosones(String s) {
        int[] count = new int[2];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - '0']++;
        }
        return count;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (String s : strs) {
            int[] count = countzerosones(s);
            for (int zeros = m; zeros >= count[0]; zeros--) {
                for (int ones = n; ones >= count[1]; ones--) {
                    dp[zeros][ones] = Math.max(dp[zeros - count[0]][ones - count[1]] + 1, dp[zeros][ones]);
                }
            }
        }
        
        return dp[m][n];
    }
}