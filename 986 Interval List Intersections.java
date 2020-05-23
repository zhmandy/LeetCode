class Solution {
    // In an interval [a, b], call b the "endpoint".
    // consider the interval A[0] with the smallest endpoint,
    // among the intervals in array B, A[0] can only intersect one such interval in array B.
    // If two intervals in B intersect A[0], then they both share the endpoint of A[0] -- but intervals in B are disjoint, which is a contradiction.
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || A[0].length == 0 || 
            B == null || B.length == 0 || B[0].length == 0) return new int[][]{};
        List<int[]> ret = new ArrayList<>();
        int pa = 0, pb = 0;
        int left, right;
        
        while (pa < A.length && pb < B.length) {
            left = Math.max(B[pb][0], A[pa][0]);
            right = Math.min(B[pb][1], A[pa][1]);
            if (left <= right) {
                ret.add(new int[]{left, right});
            }
            
            // the smallest endpoint can intersect with only one interval in the other list
            // discard this smallest endpoint and switch to the next smallest endpoint
            if (A[pa][1] <= B[pb][1]) {
                pa++;
            } else {
                pb++;
            }
        }
        
        return ret.toArray(new int[ret.size()][]);
    }
}