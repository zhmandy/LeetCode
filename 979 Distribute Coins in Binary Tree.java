class Solution {
    // consider the leaf nodes, calculate the excess of the node
    // which will be the interact between leaf nodes and root node
    // meaning moves from leaf to parent or parent to leaf are the excess combined
    int count;

    public int distributeCoins(TreeNode root) {
        count = 0;
        disHelper(root);
        return count;
    }
    
    private int disHelper(TreeNode node) {
        if (node == null) return 0;
        int left = disHelper(node.left);
        int right = disHelper(node.right);
        count += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    }
}