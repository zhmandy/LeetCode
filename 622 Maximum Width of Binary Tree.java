class Solution {
    // BFS记录node的同时记录当前层每个node的index
    // 每层的index其实都是从0开始的, 所以计算的时候只算当前层
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<Integer> index = new LinkedList<>();
        queue.offer(root);
        index.offer(1);
        int ret = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int leftmost = 0;
            int rightmost = 0;
            
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                int idx = index.poll();
                if (i == 0) leftmost = idx;
                if (i == size - 1) rightmost = idx;
                if (current.left != null) {
                    queue.offer(current.left);
                    index.offer(2 * idx);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                    index.offer(2 * idx + 1);
                }
            }
            
            ret = Math.max(ret, rightmost - leftmost + 1);
        }
        
        return ret;
    }
}