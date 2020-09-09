class Solution {
    // 和785相比就是多了一步自己整合数据成方便的结构
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if (N < 0) return false;
        if (dislikes == null || dislikes.length == 0 || dislikes[0].length == 0) return true;
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        // add dislike neighbors
        // 需要将数组的两个都作为key, 在这种条件下才可以在下面的for loop把还没处理的数字预先分在1这个color
        // 否则如果是这个例子[[1,3],[2,4],[3,4]], 如果只有单个key, 4就不是一个key, 在for loop中2会预先被分到1,
        // 但是正确来说从4出发, 2应该被归为-1类, 这样就给出错误答案
        for (int[] d : dislikes) {
            int a = d[0];
            int b = d[1];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
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
    
    private boolean dfs(int[] colors, int node, int color, HashMap<Integer, List<Integer>> graph) {
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