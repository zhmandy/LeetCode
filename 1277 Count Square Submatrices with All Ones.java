class Solution {
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int ret = 0;
        
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0];
        }
        
        for (int i = 0; i < col; i++) {
            dp[0][i] = matrix[0][i];
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 1 && dp[i - 1][j] != 0 && dp[i][j - 1] != 0 && dp[i - 1][j - 1] != 0) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                } else {
                    dp[i][j] = matrix[i][j];
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ret += dp[i][j];
            }
        }
        
        return ret;
    }
}