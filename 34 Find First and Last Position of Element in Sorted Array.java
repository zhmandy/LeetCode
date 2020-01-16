class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) return result;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        
        // starting pos
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        if (left < nums.length && nums[left] == target) {
            result[0] = left;
        }
        if (result[0] == -1) return result;
        
        left = 0;
        right = nums.length - 1;
        // ending pos
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        if (right >= 0 && nums[right] == target) {
            result[1] = right;
        }
        
        return result;
    }
}