class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        int depth = 1;
        // 因为是complete tree, 两侧向下延申即可
        // 如果左右子树高度不相等, 分别求左右子树的个数之和再加一(root)
        while(left != null && right != null) {
            depth++;
            left = left.left;
            right = right.right;
        }
        
        return left == right ? (1 << depth) - 1 : countNodes(root.left) + countNodes(root.right) + 1;
    }
}