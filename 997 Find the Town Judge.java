class Solution {
    // calculate indegree and outdegree of each node
    public int findJudge(int N, int[][] trust) {
        if (trust.length < N - 1) return -1;
        if (N == 1) return 1;
        
        int[] in = new int[N + 1];
        int[] out = new int[N + 1];
        
        for (int[] relation : trust) {
            out[relation[0]]++;
            in[relation[1]]++;
        }
        
        for (int i = 0; i <= N; i++) {
            if (in[i] == N - 1 && out[i] == 0)
                return i;
        }
        
        return -1;
    }
}