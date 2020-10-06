class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[]p2) {
                return p1[0] == p2[0] ? p2[1] - p1[1] : p1[0] - p2[0];
            }
        });
        
        int counter = intervals.length;
        int left = 0, right = 1;
        while (left < intervals.length && right < intervals.length) {
            if (intervals[left][1] >= intervals[right][1]) {
                counter--;
                right++;
            } else {
                left = right;
                right++;
            }
        }
        
        return counter;
    }
}