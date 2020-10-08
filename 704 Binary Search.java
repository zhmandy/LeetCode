class Solution {
    public int search(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right--;
            else left++;
        }
        
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        
        return -1;
    }
}