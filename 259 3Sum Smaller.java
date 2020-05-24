class Solution {
    // two pointers
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int ret = 0;
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int sum = target - nums[i];
            
            while (left < right) {
                if (nums[left] + nums[right] < sum) {
                    ret += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return ret;
    }
}