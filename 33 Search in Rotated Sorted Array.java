class Solution {
    // rotated array有两段, 要判断mid落在哪一段之后再进行和target的比较
    // 判断mid在哪一段的比较中, nums[mid] > nums[left]在左段, nums[mid] < nums[right]在右段
    // 如果用nums[mid] > nums[right]判断在左段的话, 当left, mid, right都在一段之后就会出错
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[right] > nums[mid]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }
}