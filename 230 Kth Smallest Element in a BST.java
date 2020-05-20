class Solution {
    // follow-up, 如果在insert/delete 之后找kth, 可以维护一个linkedlist去进行优化
    // 相当于在查找kth的时候就不需要遍历并压栈了, 直接O(k)的linkedlist遍历
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            current = stack.pop();
            k--;
            if (k == 0) {
                return current.val;
            }
            
            current = current.right;
        }
        
        return Integer.MIN_VALUE;
    }
}