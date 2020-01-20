/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 递归遍历对应位置是否相等
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return symmetricHelper(root.left, root.right);
    }
    
    public boolean symmetricHelper(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        return (p.val == q.val) && symmetricHelper(p.left, q.right) && symmetricHelper(p.right, q.left);
    }
}