class Solution {
    // 用一个count记录, 遇到1就加1, 遇到0就减1
    // 当count是0的时候肯定是满足要求
    // 用hashmap记录count和对应的index, 如果两个count相同, 这俩index之间的array也满足
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int ret = 0;
        
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 1 ? 1 : -1;
            if (count == 0) {
                ret = i + 1;
            } else if (map.containsKey(count)) {
                ret = Math.max(ret, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        
        return ret;
    }
}