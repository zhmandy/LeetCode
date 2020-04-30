class Solution {
    private boolean isValidHelper(TreeNode root, int[] arr, int idx) {
        if (idx == (arr.length - 1) && root != null && root.left == null && root.right == null)
            return root.val == arr[idx];
        else if (idx < arr.length && root == null)
            return false;
        else if (idx >= arr.length)
            return false;
        
        return root.val == arr[idx] && (isValidHelper(root.left, arr, idx + 1) || isValidHelper(root.right, arr, idx + 1));
    }
    
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null) return false;
        return isValidHelper(root, arr, 0);
    }
}