class Solution {
    // dp[i]表示以第i个元素结尾的最大子序和, 如果dp[i-1]小于0, 那dp[i]元素本身是一个
    // 以自己为结尾的最大自序和, 因为如果第i个数和第i-1个数相加, 都会比第i个数本身小
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int current = 0;
        
        for (int num : nums) {
            if (current < 0) {
                current = 0;
            }
            
            current += num;
            max = Math.max(max, current);
        }
        
        return max;
    }
}