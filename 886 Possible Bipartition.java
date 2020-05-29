class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if (N < 0) return false;
        if (dislikes == null || dislikes.length == 0 || dislikes[0].length == 0) return true;
        
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        // add dislike neighbors
        for (int[] d : dislikes) {
            int a = d[0];
            int b = d[1];
            graph.putIfAbsent(a, new HashSet<>());
            graph.putIfAbsent(b, new HashSet<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] colors = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (colors[i] == 0 && !dfs(colors, i, 1, graph))
                return false;
        }
        
        return true;
    }
    
    private boolean dfs(int[] colors, int node, int color, HashMap<Integer, Set<Integer>> graph) {
        if (colors[node] != 0) {
            return color == colors[node];
        }
        
        colors[node] = color;
        // current node has no dislike neighbor
        if (graph.get(node) == null) {
            return true;
        }
        
        for (int next : graph.get(node)) {
            if (!dfs(colors, next, -color, graph))
                return false;
        }
        
        return true;
    }
}