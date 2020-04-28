class Solution {
    // greedy
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max >= nums.length - 1) return true;
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
            }
        }
        
        return false;
    }
}