class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        int current = 0;
        
        while (left < right) {
            current = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(current, maxArea);
            
            if (height[left] >= height[right]) {
                right--;
            } else if (height[right] >= height[left]) {
                left++;
            }
        }
        
        return maxArea;
    }
}