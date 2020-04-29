class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        return searchHelper(root, val);
    }
    
    private TreeNode searchHelper(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (root.val < val) {
            return searchHelper(root.right, val);
        } else {
            return searchHelper(root.left, val);
        }
    }
}