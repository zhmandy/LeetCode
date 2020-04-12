class Solution {
    int max = 0;
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max - 1;
    }
}