class Solution {
    // greedy, put highest person first as the rest are invisible to him
    public int[][] reconstructQueue(int[][] people) {
        // sort height in descending order
        // sort idx in acsending order if the same height
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
            }
        });
        
        List<int[]> ret = new LinkedList<>();
        for (int[] p : people) {
            ret.add(p[1], p);
        }
        
        return ret.toArray(new int[ret.size()][2]);
    }
}