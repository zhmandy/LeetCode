class Solution {
    private class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode ptr = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (ptr.next[i] == null) {
                    ptr.next[i] = new TrieNode();
                }
                ptr = ptr.next[i];
            }
            ptr.word = word;
        }
        return root;
    }
    
    private void dfsHelper(char[][] board, int i, int j, TrieNode ptr, List<String> ret) {
        char c = board[i][j];
        if (c == '#' || ptr.next[c - 'a'] == null) return;
        ptr = ptr.next[c - 'a'];
        // find one word
        if (ptr.word != null) {
            ret.add(ptr.word);
            // make it null to prevent duplicate
            ptr.word = null;
        }
        
        board[i][j] = '#';
        if (i > 0) dfsHelper(board, i - 1, j, ptr, ret);
        if (j > 0) dfsHelper(board, i, j - 1, ptr, ret);
        if (i < board.length - 1) dfsHelper(board, i + 1, j, ptr, ret);
        if (j < board[0].length - 1) dfsHelper(board, i, j + 1, ptr, ret);
        board[i][j] = c;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ret= new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfsHelper(board, i, j, root, ret);
            }
        }
        return ret;
    }
}