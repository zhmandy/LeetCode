class Solution {
    // 因为BST中有两个node被交换了, 所以中序遍历得到的数组中应该会有两处current.val < prev.val
    // 因此确定这两个node就能够知道要swap什么
    // 在每一对错误node中, current.val一定小于prev.val, 所以在找两个node的时候, 第一次先确定一个x = prev
    // 第二次在确定y, 因为此时x != null, 所以x不会变
    
    // Stack and Queue are kinda deprecated, use Deque which has all the methods of stack and queue
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x = null;
        TreeNode y = null;
        TreeNode prev = null;
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            
            current = stack.removeLast();
            if (prev != null && current.val < prev.val) {
                y = current;
                if (x == null) {
                    x = prev;
                } else {
                    break;
                }
            }
            
            prev = current;
            current = current.right;
        }
        
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
        
        return;
    }
}