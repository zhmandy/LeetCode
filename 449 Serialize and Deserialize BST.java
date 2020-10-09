public class Codec {
    
    public StringBuilder postorder(TreeNode root, StringBuilder sb) {
        if (root == null) return sb;
        postorder(root.left, sb);
        postorder(root.right, sb);
        sb.append(root.val);
        // delimiter, separate 2-digit number
        sb.append(' ');
        return sb;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = postorder(root, new StringBuilder());
        if (sb.length() > 0) return sb.toString();
        return "";
    }
    
    public TreeNode helper(int low, int high, ArrayDeque<Integer> nums) {
        if (nums.isEmpty()) return null;
        int val = nums.getLast();
        if (val < low || val > high) return null;
        
        nums.removeLast();
        TreeNode root = new TreeNode(val);
        root.right = helper(val, high, nums);
        root.left = helper(low, val, nums);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        
        System.out.println(data);
        
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for (String s : data.split(" ")) {
            nums.add(Integer.valueOf(s));
        }
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
    }
}