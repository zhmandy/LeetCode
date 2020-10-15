class Solution {
    // Since House[1] and House[n] are adjacent, they cannot be robbed together
    // Therefore, the problem becomes to rob either House[1]-House[n-1] or House[2]-House[n]
    // depending on which choice offers more money
    // Now the problem has degenerated to the House Robber, which is already been solved
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length < 2) return nums[0];
        
        int[] dpFromFirst = new int[nums.length + 1];
        int[] dpFromSecond = new int[nums.length + 1];
        
        dpFromFirst[0] = 0;
        dpFromFirst[1] = nums[0];
        dpFromSecond[0] = 0;
        dpFromSecond[1] = 0;
        
        for (int i = 2; i <= nums.length; i++) {
            dpFromFirst[i] = Math.max(dpFromFirst[i - 1], dpFromFirst[i - 2] + nums[i - 1]);
            dpFromSecond[i] = Math.max(dpFromSecond[i - 1], dpFromSecond[i - 2] + nums[i - 1]);
        }
        
        return Math.max(dpFromFirst[nums.length - 1], dpFromSecond[nums.length]);
    }
}