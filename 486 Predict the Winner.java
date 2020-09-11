class Solution {
    // each player tries to maximize the total score
    // dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
    public boolean PredictTheWinner(int[] nums) {
        int size = nums.length;
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) dp[i][i] = nums[i];
        // len: steps away from diagonal line
        for (int left = size - 2; left >= 0; left--) {
            for (int len = 1; len + left < size; len++) {
                int right = left + len;
                dp[left][right] = Math.max(nums[left] - dp[left + 1][right], nums[right] - dp[left][right - 1]);
            }
        }
        
        return dp[0][size - 1] >= 0;
    }
}