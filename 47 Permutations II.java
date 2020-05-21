class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        permuteHelper(nums, result, new ArrayList<>(), used);
        return result;
    }
    
    private void permuteHelper(int[] nums, List<List<Integer>> result, List<Integer> current, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        } else {
            // pre is for the current position
            int pre = nums[0] - 1;
            for (int i = 0; i < nums.length; i++) {
                if (!used[i] && nums[i] != pre) {
                    pre = nums[i];
                    current.add(nums[i]);
                    used[i] = true;
                    permuteHelper(nums, result, current, used);
                    current.remove(current.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
}