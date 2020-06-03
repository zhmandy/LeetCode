class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int len = 1;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != pre) {
                pre = nums[i];
                nums[len] = nums[i];
                len++;
            }
        }
        
        return len;
    }
}