class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new LinkedList<>();
        if (graph == null || graph.length == 0 || graph[0].length == 0) return result;
        
        List<Integer> current = new LinkedList<>();
        helper(graph, 0, current, result);
        
        return result;
    }
    
    private void helper(int[][] graph, int idx, List<Integer> current, List<List<Integer>> result) {
        current.add(idx);
        int[] next = graph[idx];
        if (idx == graph.length - 1) {
            result.add(new LinkedList<>(current));
            return;
        }
        
        for (int i = 0; i < next.length; i++) {
            helper(graph, next[i], current, result);
            current.remove(current.size() - 1);
        }
    }
}