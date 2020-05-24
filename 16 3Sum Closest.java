class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            
            // should at least run one round to update diff
            // otherwise it's max_value
            if (diff == 0 || nums[i] > target)
                break;
        }
        
        // return sum of three by subtracting diff from target
        return target - diff;
    }
}