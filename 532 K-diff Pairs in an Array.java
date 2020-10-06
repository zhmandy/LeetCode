class Solution {
    // two pointers
    public int findPairs(int[] nums, int k) {
         Arrays.sort(nums);

        int left = 0, right = 1;
        int counter = 0;
        
        while (left < nums.length && right < nums.length) {
            if (left == right || nums[right] - nums[left] < k) {
                right++;
            } else if (nums[right] - nums[left] > k) {
                left++;
            } else {
                counter++;
                left++;
                while (left < nums.length && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
        
        return counter;
    }
}