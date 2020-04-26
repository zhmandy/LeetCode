class Solution {
    // BFS or DFS
    // label the already visited nodes
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int ret = 0;
        int nr = grid.length;
        int nc = grid[0].length;
        Deque<Integer> queue = new ArrayDeque<>();
        
        for (int i = 0; i < nr; i ++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    queue.offer(i * nc + j);
                    grid[i][j] = '0';
                    ret++;
                    
                    while (!queue.isEmpty()) {
                        int idx = queue.poll();
                        int r = idx / nc;
                        int c = idx % nc;
                        
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            queue.offer((r - 1) * nc + c);
                            grid[r - 1][c] = '0';
                        }
                        
                        if (r + 1 < nr && grid[r + 1][c] == '1') {
                            queue.offer((r + 1) * nc + c);
                            grid[r + 1][c] = '0';
                        }
                        
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            queue.offer(r * nc + c - 1);
                            grid[r][c - 1] = '0';
                        }
                        
                        if (c + 1 < nc && grid[r][c + 1] == '1') {
                            queue.offer(r * nc + c + 1);
                            grid[r][c + 1] = '0';
                        }
                    }
                }
            }
        }
        return ret;
    }
}