class Solution {
    // toplogical sort
    // if any node has nonzero indegree, there is a loop
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 0) return false;
        if (prerequisites == null || prerequisites.length == 0) return true;
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        Deque<Integer> queue = new LinkedList<>();
        
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
            
            if (graph.containsKey(pair[1])) {
                graph.get(pair[1]).add(pair[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(pair[0]);
                graph.put(pair[1], list);
            }
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (graph.get(current) == null) {
                continue;
            }
            
            for (int next : graph.get(current)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
}