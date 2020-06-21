class Solution {
    // dfs
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        if (board.length < 2 || board[0].length < 2) return;
        
        int row = board.length;
        int col = board[0].length;
        
        // change 'O' that locates on the border to '*'
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                dfsHelper(board, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                dfsHelper(board, i, col - 1);
            }
        }
        
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                dfsHelper(board, 0, j);
            }
            if (board[row - 1][j] == 'O') {
                dfsHelper(board, row - 1, j);
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void dfsHelper(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (board[i][j] == 'O') {
            board[i][j] = '*';
        }
        if (i > 1 && board[i - 1][j] == 'O') {
            dfsHelper(board, i - 1, j);
        }
        if (i < board.length - 2 && board[i + 1][j] == 'O') {
            dfsHelper(board, i + 1, j);
        }
        if (j > 1 && board[i][j - 1] == 'O') {
            dfsHelper(board, i, j - 1);
        }
        if (j < board[0].length - 2 && board[i][j + 1] == 'O') {
            dfsHelper(board, i, j + 1);
        }
    }
}