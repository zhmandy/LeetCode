class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    
    private TreeNode buildTreeHelper(int[] postorder, int[] inorder, int post_start, int in_start, int in_end) {
        if (in_start > in_end || post_start >= postorder.length) return null;
        if (in_start == in_end) return new TreeNode(inorder[in_start]);
        
        TreeNode current = new TreeNode(postorder[post_start]);
        int idx = map.get(postorder[post_start]);
        
        current.left = buildTreeHelper(postorder, inorder, post_start - (in_end - idx + 1), in_start, idx - 1);
        current.right = buildTreeHelper(postorder, inorder, post_start - 1, idx + 1, in_end);
        
        return current;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return buildTreeHelper(postorder, inorder, postorder.length - 1, 0, inorder.length - 1);
    }
}