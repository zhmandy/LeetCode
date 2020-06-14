class Solution {
    // dp, dp[i]表示到i为止最长的长度
    // 嵌套循环去找可整除的, 对于当前数i, 从i-1循环到0, 如果可以整除且能够更新dp[i]
    // 更新dp[i]并判断是否更新最长长度, 如果更新maxLen, 也更新输出答案用的idx
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        int idx = 0;
        int maxLen = 0;
        int[] dp = new int[nums.length];
        int[] parent = new int[nums.length];
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                    
                    if (dp[i] > maxLen) {
                        maxLen = dp[i];
                        idx = i;
                    }
                }
            }
        }
        
        List<Integer> ret = new ArrayList<>();
        while (maxLen >= 0) {
            ret.add(nums[idx]);
            idx = parent[idx];
            maxLen--;
        }
        
        return ret;
    }
}