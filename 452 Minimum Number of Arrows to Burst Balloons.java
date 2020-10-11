class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        // for testcase: [[-2147483646,-2147483645],[2147483646,2147483647]]
        Arrays.sort(points, (a, b) -> a[1] > b[1] ? 1 : -1);
        int prev = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (prev >= points[i][0]) continue;
            count++;
            prev = points[i][1];
        }
        
        return count;
    }
}