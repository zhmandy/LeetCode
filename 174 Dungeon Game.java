class Solution {
    // dynamic programming
    // 要根据最后destination的值和future loss来从后往前更新dp
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] health = new int[row][col];
        
        // initial: health[row-1][col-1] = Math.max(1, 1-dungeon[m-1][n-1])
        // induction role:
        // health[i][j-1] = max(health[i+1][col-1] - dungeon[i][col-1], 1)
        // health[row-1][j] = max(health[row-1][j+1] - dungeon[row-1][j], 1)
        // health[i][j] = min(max(health[i][j+1] - dungeon[i][j], 1), max(health[i+1][j] - dungeon[i][j], 1))
        
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) {
                    health[row - 1][col - 1] = Math.max(1, 1 - dungeon[row - 1][col - 1]);
                } else if (i == row - 1) {
                    health[row - 1][j] = Math.max(health[row - 1][j + 1] - dungeon[row - 1][j], 1);
                } else if (j == col - 1) {
                    health[i][col - 1] = Math.max(health[i + 1][col - 1] - dungeon[i][col - 1], 1);
                } else {
                    health[i][j] = Math.min(Math.max(health[i][j + 1] - dungeon[i][j], 1), Math.max(health[i + 1][j] - dungeon[i][j], 1));
                }
            }
        }
        
        return health[0][0];
    }
}