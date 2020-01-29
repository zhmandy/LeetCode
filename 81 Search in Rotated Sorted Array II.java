class Solution {
    // worst case 1 1 1 1 0 1 1
    // 就是在重复数字的地方rotate了, 所以要先用while循环保证头尾不一样
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;
        int mid;
        
        while (left + 1 < right) {
            if (nums[left] == nums[right]) {
                left++;
            } else {
                break;
            }
        }
        
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[right] >= nums[mid]) {
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        
        if (nums[left] == target || nums[right] == target) return true;
        return false;
    }

    // v2
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
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
        
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[right] >= nums[mid]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        if (nums[left] == target || nums[right] == target) return true;
        return false;
    }
}