class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
        // use map to store edge info, src -> (dst -> cost)
        for (int[] info : flights) {
            if (!prices.containsKey(info[0]))
                prices.put(info[0], new HashMap<>());
            prices.get(info[0]).put(info[1], info[2]);
        }
        
        // priority queue based on total cost so far
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
        queue.add(new int[]{0, src, K + 1});
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int cost = top[0];
            int city = top[1];
            int k = top[2];
            
            if (city == dst) return cost;
            // each potential path has an associated k and cost so far, kinda like backtracking
            if (k > 0) {
                Map<Integer, Integer> map = prices.getOrDefault(city, new HashMap<>());
                for (int a : map.keySet()) {
                    queue.add(new int[]{cost + map.get(a), a, k - 1});
                }
            }
        }
        
        return -1;
    }
}