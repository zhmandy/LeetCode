class Solution {
    // 固定kth的数, 从k+1开始和之后的数都互换构成新的permutation
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) return ret;
        permuteHelper(nums, ret, 0);
        return ret;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void permuteHelper(int[] nums, List<List<Integer>> ret, int idx) {
        if (idx == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for (int num : nums) {
                cur.add(num);
            }
            ret.add(cur);
            return;
        }
        
        for (int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            permuteHelper(nums, ret, idx + 1);
            swap(nums, idx, i);
        }
    }
}