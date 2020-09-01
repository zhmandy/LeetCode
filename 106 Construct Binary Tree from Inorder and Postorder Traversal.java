class Solution {
    // postorder从后往前就是rootNode, 根据这个rootNode在inorder里面分出当前这个rootNode的左和右
    // 定位到左和右的子rootNode, 递归构建tree
    private TreeNode buildHelper(int[] inorder, int[] postorder, int pos_start, int in_start, int in_end, Map<Integer, Integer> map) {
        if (pos_start >= postorder.length || in_start > in_end) return null;
        if (in_start == in_end) return new TreeNode(inorder[in_start]);
        
        TreeNode current = new TreeNode(postorder[pos_start]);
        int idx = map.get(postorder[pos_start]);
        
        current.left = buildHelper(inorder, postorder, pos_start - (in_end - idx + 1), in_start, idx - 1, map);
        current.right = buildHelper(inorder, postorder, pos_start - 1, idx + 1, in_end, map);
        
        return current;
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return buildHelper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1, map);
    }
}