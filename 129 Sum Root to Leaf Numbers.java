class Solution {
    
    private int sum;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        sum = 0;
        sumHelper(root, 0);
        return sum;
    }
    
    private void sumHelper(TreeNode root, int current) {
        if (root == null) return;
        current = current * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += current;
            return;
        }
        
        sumHelper(root.left, current);
        sumHelper(root.right, current);
    }
}