class Solution {
    // 先找到对应的行, 再二分法找target
    // 找行的时候不二分, 遍历同时判断target是否存在当前行范围中
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int[] nums = null;
        for (int[] ints : matrix) {
            if (ints[0] <= target && ints[matrix[0].length - 1] >= target) {
                nums = ints;
                break;
            }
        }
        if (nums == null) return false;
        
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}