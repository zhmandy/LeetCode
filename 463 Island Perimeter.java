class Solution {
    // loop every block and check surroundings
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int ret = 0;
        int up, down, left, right;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0) {
                        up = 0;
                    } else {
                        up = grid[i - 1][j] == 1 ? 1 : 0;
                    }
                    if (j == 0) {
                        left = 0;
                    } else {
                        left = grid[i][j - 1] == 1 ? 1 : 0;
                    }
                    if (i == grid.length - 1) {
                        down = 0;
                    } else {
                        down = grid[i + 1][j] == 1 ? 1 : 0;
                    }
                    if (j == grid[0].length - 1) {
                        right = 0;
                    } else {
                        right = grid[i][j + 1] == 1 ? 1 : 0;
                    }
                    ret += 4 - (up + down + left + right);
                }
            }
        }
        return ret;
    }
}