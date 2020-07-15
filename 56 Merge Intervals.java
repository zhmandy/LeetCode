class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(final int[] p, final int[] q) {
                // be aware of this
                return p[0] < q[0] ? -1 : p[0] == q[0] ? 0 : 1; 
            }
        });
        
        int idx = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[idx][1] && intervals[i][0] >= intervals[idx][0]) {
                intervals[idx][1] = Math.max(intervals[idx][1], intervals[i][1]);
            } else {
                idx++;
                intervals[idx] = intervals[i];
            }
        }
        
        int[][] ret = new int[idx + 1][2];
        for (int i = 0; i <= idx; i++) {
            ret[i] = intervals[i];
        }
        
        return ret;
    }
}