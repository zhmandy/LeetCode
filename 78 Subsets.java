class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) return ret;
        
        Arrays.sort(nums);
        subsetHelper(nums, 0, ret, new ArrayList<>());
        
        return ret;
    }
    
    private void subsetHelper(int[] nums, int idx, List<List<Integer>> ret, List<Integer> current) {
        ret.add(new ArrayList<>(current));
        
        for (int i = idx; i < nums.length; i++) {
            current.add(nums[i]);
            subsetHelper(nums, i + 1, ret, current);
            current.remove(current.size() - 1);
        }
    }
}