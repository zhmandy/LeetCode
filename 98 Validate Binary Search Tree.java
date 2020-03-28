class Solution {
    // 需要注意的是pre的类型应该为double, BST中最小数的值可能为Integer.MIN_VALUE
    // 所以初始化的pre, 为Integer.MIN_VALUE - 1, 所以要用double来初始化
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        Stack<TreeNode> stack = new Stack<>();
        //Double.MIN_VALUE holds the value 2-1074. This is a positive value
        //as opposed to Integer.MIN_VALUE which holds the negative value -2147483648
        //The reason is most likely that the smallest double value is easily expressed as -Double.MAX_VALUE
        double pre = -Double.MAX_VALUE;
        
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            current = stack.pop();
            if (current.val > pre) {
                pre = current.val;
                current = current.right;
            } else {
                return false;
            }
        }
        
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    // Integer can use null
    // level traversal, check if each node satisfy min and max
    public boolean isValidBSTHelper(TreeNode root, Integer min, Integer max){
        if(root == null){
            return true;
        }
        if((min != null && root.val <= min) || (max != null && root.val >= max)){
            return false;
        }
        return isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right, root.val, max);
    }
}