class RecentCounter {
    
    Deque<Integer> window;

    public RecentCounter() {
        window = new LinkedList<>();
    }
    
    public int ping(int t) {
        window.offer(t);
        
        while (!window.isEmpty()) {
            if (window.peek() < t - 3000) window.poll();
            else break;
        }
        
        return window.size();
    }
}