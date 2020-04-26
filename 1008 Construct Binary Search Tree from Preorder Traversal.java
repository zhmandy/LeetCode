// recursive
class Solution {
    private int idx;
    private int size;
    private int[] preorder;
    
    private TreeNode builder(int min, int max) {
        if (idx == size) return null;
        
        int val = preorder[idx];
        if (val < min || val > max) return null;
        
        idx++;
        TreeNode root = new TreeNode(val);
        root.left = builder(min, val);
        root.right = builder(val, max);
        return root;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        this.idx = 0;
        this.size = preorder.length;
        this.preorder = preorder;
        
        return builder(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}

// iteration
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = stack.peek();
            TreeNode child = new TreeNode(preorder[i]);
            
            // adjust the parent
            while(!stack.isEmpty() && child.val > stack.peek().val) {
                node = stack.pop();
            }
            
            if (child.val < node.val) {
                node.left = child;
            } else {
                node.right = child;
            }
            
            // we assume each child is the parent of next subtree
            // if it's not, adjust it in the while loop
            stack.push(child);
        }
        
        return root;
    }
}