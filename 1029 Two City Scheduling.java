class Solution {
    // sort costs by price A - price B (a gain which company has 
    // by sending a person to city A and not to city B)
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] cost1, int[] cost2) {
                return (cost1[0] - cost1[1]) - (cost2[0] - cost2[1]);
            }
        });
        
        int ret = 0;
        int n = costs.length / 2;
        for (int i = 0; i < costs.length; i++) {
            ret += (i < n) ? costs[i][0] : costs[i][1];
        }
        
        return ret;
    }
}