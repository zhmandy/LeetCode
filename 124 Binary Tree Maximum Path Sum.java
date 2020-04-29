class Solution {
    private int ret;
    private int sumHelper(TreeNode root) {
        if (root == null) return 0;
        
        int left = Math.max(sumHelper(root.left), 0);
        int right = Math.max(sumHelper(root.right), 0);
        
        int result = left + right + root.val;
        ret = Math.max(ret, result);
        
        return Math.max(left, right) + root.val;
    }
    
    public int maxPathSum(TreeNode root) {
        ret = Integer.MIN_VALUE;
        sumHelper(root);
        return ret;
    }
}