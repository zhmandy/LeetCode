class Solution {
    // one pass, keep update the min_value and the max_value
    // calculate result before updating those two to make sure they are from different arrays
    public int maxDistance(List<List<Integer>> arrays) {
        int ret = 0;
        int min_value = arrays.get(0).get(0);
        int max_value = arrays.get(0).get(arrays.get(0).size() - 1);
        
        for (int i = 1; i < arrays.size(); i++) {
            ret = Math.max(ret, Math.max(Math.abs(max_value - arrays.get(i).get(0)), Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min_value)));
            min_value = Math.min(min_value, arrays.get(i).get(0));
            max_value = Math.max(max_value, arrays.get(i).get(arrays.get(i).size() - 1));
        }
        
        return ret;
    }
}
