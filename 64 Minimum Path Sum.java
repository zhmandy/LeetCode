class Solution {
    // dp from the end to the start
    // this code uses 1D array
    // if choose the right one, just add dp[j+1] as it is updated already
    // if choose the bottom one, add dp[j] as the value stored in this cell is the value from previous row
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int[] dp = new int[grid[0].length];
        
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if (i == grid.length - 1 && j != grid[0].length - 1) {
                    dp[j] = grid[i][j] + dp[j + 1];
                } else if (i != grid.length - 1 && j == grid[0].length - 1) {
                    dp[j] = grid[i][j] + dp[j];
                } else if (i != grid.length - 1 && j != grid[0].length - 1) {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                } else {
                    dp[j] = grid[i][j];
                }
            }
        }
        
        return dp[0];
    }
}