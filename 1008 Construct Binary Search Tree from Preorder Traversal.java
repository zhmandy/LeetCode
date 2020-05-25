// recursive: better one
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        return helper(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) return null;
        
        TreeNode root = new TreeNode(preorder[start]);
        int i;
        for (i = start + 1; i <= end; i++) {
            if (preorder[i] > preorder[start]) {
                break;
            }
        }
        
        root.left = helper(preorder, start + 1, i - 1);
        root.right = helper(preorder, i, end);
        return root;
    }
}

// recursive: should pay attention to that idx is global
class Solution {
    // idx should be global, and keep ++ rather than ++ a local var
    private int idx;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        idx = 0;
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int[] preorder, int min, int max) {
        int index = idx;
        if (idx == preorder.length) return null;
        
        int val = preorder[idx];
        if (val < min || val > max) return null;
        
        idx++;
        TreeNode root = new TreeNode(val);
        root.left = helper(preorder, min, val);
        root.right = helper(preorder, val, max);
        return root;
    }
}

// iteration
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        
        for (int i = 1; i < preorder.length; i++) {
            TreeNode child = new TreeNode(preorder[i]);
            TreeNode node = stack.peek();
            
            // find correct TreeNode to attach child
            while (!stack.isEmpty() && child.val > stack.peek().val) {
                node = stack.pop();
            }
            
            if (child.val < node.val) {
                node.left = child;
            } else if (child.val > node.val) {
                node.right = child;
            }
            
            stack.push(child);
        }
        
        return root;
    }
}