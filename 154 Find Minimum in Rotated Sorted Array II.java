class Solution {
    // 去掉头尾重复的, 在153基础上调换两个if判断的顺序
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        
        while (left < right) {
            if (nums[left] == nums[right]) {
                left++;
            } else {
                break;
            }
        }
        
        while (left <= right) {
            mid = left + (right - left) / 2;
            
            if (nums[mid] <= nums[right]) {
                if (mid > 0 && nums[mid] < nums[mid - 1]) {
                    return Math.min(nums[mid], nums[0]);
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] >= nums[0]) {
                left = mid + 1;
            }
        }
        
        return nums[0];
    }
}