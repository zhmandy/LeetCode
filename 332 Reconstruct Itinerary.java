class Solution {
    // backtracking + greedy
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ret = new ArrayList<>();
        if (tickets == null || tickets.size() == 0) return ret;
        
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            if (map.containsKey(ticket.get(0))) {
                map.get(ticket.get(0)).add(ticket.get(1));
            } else {
                PriorityQueue<String> queue = new PriorityQueue<>();
                queue.add(ticket.get(1));
                map.put(ticket.get(0), queue);
            }
        }
        
        dfsHelper("JFK", map, ret);
        Collections.reverse(ret);
        return ret;
    }
    
    private void dfsHelper(String dep, HashMap<String, PriorityQueue<String>> map, List<String> ret) {
        PriorityQueue<String> arrivals = map.get(dep);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfsHelper(arrivals.poll(), map, ret);
        }
        ret.add(dep);
    }
}