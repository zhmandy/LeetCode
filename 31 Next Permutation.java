class Solution {
    // 从后往前遍历, 当找到一个nums[i]比nums[i+1]的时候, 说明这个数还可以更大
    // 也就意味着有permutation, 所以可以将i和之后比nums[i]大的最小的数交换
    // 然后将后面部分重新排序, 就能得到最接近的permutation
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        
        int replaceIdx = 0;
        for (replaceIdx = nums.length - 2; replaceIdx >= 0; replaceIdx--) {
            if (nums[replaceIdx] < nums[replaceIdx + 1]) {
                break;
            }
        }
        
        if (replaceIdx < 0) {
            Arrays.sort(nums);
            return;
        }
        
        Arrays.sort(nums, replaceIdx + 1, nums.length);
        for (int i = replaceIdx; i < nums.length; i++) {
            if (nums[i] > nums[replaceIdx]) {
                int tmp = nums[i];
                nums[i] = nums[replaceIdx];
                nums[replaceIdx] = tmp;
                break;
            }
        }
    }
}