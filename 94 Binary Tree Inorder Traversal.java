class Solution {
    // inorder traversal recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inHelper(root, res);
        return res;
    }
    
    public void inHelper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                inHelper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                inHelper(root.right, res);
            }
        }
    }
    
    // inorder traversal iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            current = stack.pop();
            res.add(current.val);
            current = current.right;
        }
        
        return res;
    }
    
    // preorder traversal recursive
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preHelper(root, res);
        return res;
    }
    
    public void preHelper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                preHelper(root.left, res);
            }
            if (root.right != null) {
                preHelper(root.right, res);
            }
        }
    }
    
    // preorder traversal iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                res.add(current.val);
                stack.push(current);
                current = current.left;
            }
            
            current = stack.pop();
            current = current.right;
        }
        
        return res;
    }
    
    // postorder traversal recursive
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postHelper(root, res);
        return res;
    }
    
    public void postHelper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                postHelper(root.left, res);
            }
            if (root.right != null) {
                postHelper(root.right, res);
            }
            res.add(root.val);
        }
    }   
    
    // postorder traversal iterative
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode current = root;
        TreeNode lastVisit = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            current = stack.peek();
            if (current.right == null || current.right == lastVisit) {
                res.add(current.val);
                stack.pop();
                lastVisit = current;
                current = null;
            } else {
                current = current.right;
            }
        }
        
        return res;
    }    
}