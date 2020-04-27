class Solution {
    // the code could be more concise with matrix[m + 1][n + 1]
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxLen = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = (matrix[i][0] == '1') ? 1 : 0;
            maxLen = Math.max(maxLen, dp[i][0]);
        }
        
        for (int j = 0; j < matrix[0].length; j++) {
            dp[0][j] = (matrix[0][j] == '0') ? 0 : 1;
            maxLen = Math.max(maxLen, dp[0][j]);
        }
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        
        return maxLen * maxLen;
    }
}