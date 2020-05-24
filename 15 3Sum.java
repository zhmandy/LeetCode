class Solution {
    // two pointers
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length < 3) return ret;
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum > target || (right < nums.length - 1 && nums[right] == nums[right + 1])) {
                    right--;
                } else if (sum < target || (left > i + 1 && nums[left] == nums[left - 1])) {
                    left++;
                } else {
                    ret.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
            }
        }
        
        return ret;
    }
}