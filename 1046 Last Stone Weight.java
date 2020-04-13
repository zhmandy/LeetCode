class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        
        int first = maxHeap.poll();
        int second;
        
        while (!maxHeap.isEmpty()) {
            second = maxHeap.poll();
            if (first == second) {
                maxHeap.add(0);
            } else {
                maxHeap.add(Math.abs(first - second));
            }
            first = maxHeap.poll();
        }
        
        return first;
    }
}