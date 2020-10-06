class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int counter = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] - nums[i] == k) {
                    counter++;
                    break;
                }
                else if (nums[mid] - nums[i] > k) right--;
                else left++;
            }
        }
        
        return counter;
    }
}