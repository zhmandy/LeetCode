class Solution {
    // BFS
    // add NULL to mark siblings territory
    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            boolean siblings = false;
            boolean cousins = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.remove();
                if (current == null) {
                    if (i == size - 1 && cousins == true) {
                        return false;
                    }
                    siblings = false;
                    continue;
                }
                
                if (current.val == x || current.val == y) {
                    if (siblings == false && cousins == true)
                        return true;
                    siblings = true;
                    cousins = true;
                }
                
                if (current.left != null) {
                    queue.add(current.left);
                }
                
                if (current.right != null) {
                    queue.add(current.right);
                }
                
                queue.add(null);
            }
        }
        
        return false;
    }
}