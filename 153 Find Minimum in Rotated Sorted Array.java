class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else if (nums[mid] <= nums[right]) {
                if (nums[mid] < nums[mid - 1]) {
                    return Math.min(nums[mid], nums[0]);
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return nums[0];
    }
}