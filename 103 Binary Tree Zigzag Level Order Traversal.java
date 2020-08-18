class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    level.add(current.val);
                    if (current.left != null) queue.offer(current.left);
                    if (current.right != null) queue.offer(current.right);
                }
            }
            
            if (flag) {
                Collections.reverse(level);
                result.add(level);
                flag = false;
            } else {
                result.add(level);
                flag = true;
            }
        }
        return result;
    }
}