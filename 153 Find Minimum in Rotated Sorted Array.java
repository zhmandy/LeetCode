class Solution {
    // if larger than nums[right], must be in the left half
    // if smaller than nums[right], must be in the right half
    // if equals to nums[right], no harm to do right--
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