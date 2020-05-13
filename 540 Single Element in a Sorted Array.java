class Solution {
    // check the length of left/right part
    // the part with odd length is the part that contains target
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            boolean half = (high - mid) % 2 == 0;
            if (nums[mid + 1] == nums[mid]) {
                if (half) {
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (half) {
                    high = mid - 2;
                } else {
                    low = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        
        return nums[low];
    }
}