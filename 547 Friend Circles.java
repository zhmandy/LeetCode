class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) return 0;
        int[] visited = new int[M.length];
        int count = 0;
        
        for (int i = 0; i < M.length; i++) {
            // this person hasn't been checked
            if (visited[i] == 0) {
                findHelper(M, visited, i);
                count++;
            }
        }
        
        return count;
    }
    
    private void findHelper(int[][] M, int[] visited, int idx) {
        for (int i = 0; i < M.length; i++) {
            if (M[idx][i] == 1 && visited[i] == 0) {
                visited[i] = 1;
                findHelper(M, visited, i);
            }
        }
    }
}