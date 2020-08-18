class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0,1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (helper(board, visited, i, j, 0, word)) return true;
            }
        }
        
        return false;
    }
    
    private boolean helper(char[][] board, boolean[][] visited, int i, int j, int length, String word) {
        if (length == word.length()) return true;
        
        int row = board.length, col = board[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col) return false;
        if (visited[i][j]) return false;
        if (board[i][j] != word.charAt(length)) return false;
        
        visited[i][j] = true;
        for (int[] dir : directions) {
            if (helper(board, visited, i + dir[0], j + dir[1], length + 1, word)) return true;
        }
        visited[i][j] = false;
        return false;
    }
}