class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int max = nums[0];
        int min = nums[0];
        int result = max;
        
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            // pick current: preceding zero or preceding negative number
            // pick max*current: all positive
            // pick min*current: even number of negative value
            int temp_max = Math.max(current, Math.max(max * current, min * current));
            // pick current: max/min negative or zero && current negative
            min = Math.min(current, Math.min(max * current, min * current));
            
            max = temp_max;
            result = Math.max(max, result);
        }
        
        return result;
    }
}