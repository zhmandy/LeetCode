class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        swap(root);
        return root;
    }
    
    private void swap(TreeNode root) {
        if (root == null) return;
        if (root.left != null && root.right != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        } else if (root.left != null) {
            root.right = root.left;
            root.left = null;
        } else {
            root.left = root.right;
            root.right = null;
        }
        
        swap(root.left);
        swap(root.right);
    }
}