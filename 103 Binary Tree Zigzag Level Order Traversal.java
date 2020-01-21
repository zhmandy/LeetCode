/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // BFS遍历, 偶数行reverse
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                if (head != null) {
                    level.add(head.val);
                    if (head.left != null) {
                        queue.offer(head.left);
                    }
                    if (head.right != null) {
                        queue.offer(head.right);
                    }
                }
            }

            // or use stack
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