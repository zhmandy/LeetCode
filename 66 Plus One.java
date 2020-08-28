class Solution {
    // same as 153
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1, mid;
        
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right--;
            } else if (nums[mid] > nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return Math.min(nums[left], nums[right]);
    }
}