class Solution {
    // recursion
    // 1.stop: min > max
    // 2.create root
    // 3.helper function get left list and right list
    // 4.combie root with left and right (4 conditions)
    // 5.return list
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }
    
    public List<TreeNode> helper(int min, int max) {
        List<TreeNode> res = new ArrayList<>();
        if (min > max) {
            return res;
        }
        
        for (int cur = min; cur <= max; cur++) {
            // cannot create root node here
            // root has its own memory space
            // for each result, should create new space for it
            // otherwise, for the same root, current result will overwrite the previous one
            List<TreeNode> left = helper(min, cur - 1);
            List<TreeNode> right = helper(cur + 1, max);
            
            if (left.size() == 0 && right.size() == 0) {
                TreeNode root = new TreeNode(cur);
                res.add(root);
            } else if (left.size() == 0) {
                for (int i = 0; i < right.size(); i++) {
                    TreeNode root = new TreeNode(cur);
                    root.right = right.get(i);
                    res.add(root);
                }
            } else if (right.size() == 0) {
                for (int i = 0; i < left.size(); i++) {
                    TreeNode root = new TreeNode(cur);
                    root.left = left.get(i);
                    res.add(root);
                }
            } else {
                for (int i = 0; i < left.size(); i++) {
                    for (int j = 0; j < right.size(); j++) {
                        TreeNode root = new TreeNode(cur);
                        root.left = left.get(i);
                        root.right = right.get(j);
                        res.add(root);
                    }
                }
            }
        }
        
        return res;
    }
}