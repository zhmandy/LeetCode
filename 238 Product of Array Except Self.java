class Solution {
    // loop1: 从左到右只存左半边的乘积 (刚好是累乘)
    // loop2: 从右到左乘上右半边乘积 (用right保存当前值右边的类成结果)
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
                
        ret[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ret[i] = ret[i - 1] * nums[i - 1];
        }
        
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ret[i] *= right;
            right *= nums[i];
        }
        
        return ret;
    }
}