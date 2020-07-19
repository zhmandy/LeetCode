class Solution {
    // topological sort
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ret = new int[numCourses];
        if (numCourses < 0) return ret;
        
        for (int i = 0; i < numCourses; i++)
            ret[i] = i;
        if (prerequisites == null || prerequisites.length == 0) return ret;
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            if (graph.containsKey(pair[1])) {
                graph.get(pair[1]).add(pair[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(pair[0]);
                graph.put(pair[1], list);
            }
            
            indegree[pair[0]] += 1;
        } 
        
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }
        
        int idx = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            ret[idx] = current;
            idx++;
            System.out.println(current);
            System.out.println(queue.isEmpty());
            System.out.println(graph.size());
            List<Integer> list = graph.getOrDefault(current, null);
            if (list != null) {
                for (int course : list) {
                    indegree[course] -= 1;
                    if (indegree[course] == 0) {
                        queue.offer(course);
                    }
                    graph.remove(current);
                }
            }
        }
        
        if (graph.size() == 0) {
            return ret;
        } else {
            return new int[0];
        }  
    }
}