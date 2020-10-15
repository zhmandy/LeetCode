class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;
        
        Arrays.sort(intervals, (a, b)->(a[0] - b[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(intervals.length, (a, b)->(a - b));
        
        // add first meeting's end time
        queue.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= queue.peek()) {
                queue.poll();
            }
            queue.add(intervals[i][1]);
        }
        
        return queue.size();
    }
}