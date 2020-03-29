class Solution {
    // The first element in the preorder list is a root. This root splits inorder list into left and right subtrees
    // Now one have to pop up the root from preorder list since it's already used as a tree node
    // then repeat the step above for the left and right subtrees
    private Map<Integer, Integer> map = new HashMap<>();
    
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int pre_start, int in_start, int in_end) {
        if (in_start > in_end || pre_start >= preorder.length) return null;
        if (in_start == in_end) return new TreeNode(inorder[in_start]);
        
        TreeNode current = new TreeNode(preorder[pre_start]);
        int idx = map.get(preorder[pre_start]);
        
        current.left = buildTreeHelper(preorder, inorder, pre_start + 1, in_start, idx - 1);
        current.right = buildTreeHelper(preorder, inorder, pre_start + (idx - in_start + 1), idx + 1, in_end);
        return current;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return buildTreeHelper(preorder, inorder, 0, 0, inorder.length - 1);
    }
}