class Solution {
    // color neighbor with different color
    public boolean isBipartite(int[][] graph) {
        if (graph == null) return false;
        if (graph.length == 0) return true;
        
        int n = graph.length;
        int[] colors = new int[n];
        int color = 1;
        
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, color, i))
                return false;
        }
        
        return true;
    }
    
    private boolean dfs(int[][] graph, int[] colors, int color, int idx) { 
        if (colors[idx] != 0) {
            return colors[idx] == color;
        }
        
        colors[idx] = color;
        for (int next : graph[idx]) {
            if (!dfs(graph, colors, -color, next))
                return false;
        }
        
        return true;
    }
}