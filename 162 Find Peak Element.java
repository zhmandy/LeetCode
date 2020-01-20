class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid == 0 || (mid > 0 && nums[mid] > nums[mid - 1])) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right >= 0) return right;
        else return -1;
    }
}