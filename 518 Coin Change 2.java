class Solution {
    // 递归会超时
    // Arrays.sort()没法直接降序排序primitive type的数组, 只能升序之后手动reverse
    // 这题使用动态规划: 取当前这个coin + 不取这个coin
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = (j - coins[i - 1] >= 0) ? dp[i - 1][j] + dp[i][j - coins[i - 1]] : dp[i - 1][j];
            }
        }
        
        return dp[coins.length][amount];
    }
}