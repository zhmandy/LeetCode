class Solution {
    // when n = 1, total 1 BST
    // when n = 2, total 2 BSTs [null 1 2], [1 2 null]
    // when n = 3, total 5 BSTs
    // 1 as root, left is null, right 2 or 3
    // 2 as root, left is 1, right is 3
    // 3 as root, left 1 or 2, right is null
    // when n = 4, 1 as root, 3 numbers to form right node which is also a BST, total 5
    // 2 as root, left is 1, right: 3 & 4 to form BSTs, total 2
    // 3 as root, left total 2, right is 4
    // 4 as root, left total 5, right total 1
    // finding: left from 0 to k-1 (k: current #), corresponding right k-1 to 0
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        
        return dp[n];
    }
}