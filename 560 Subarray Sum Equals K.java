class Solution {
    // prefix sum, total sum up to current index
    // hashmap keeps track the frequency of each prefix sum
    // for current index, we try to find if there exsits sum[i]-k
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int ret = 0;
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // sum[i]−sum[j]=k
            if (map.containsKey(sum - k)) {
                ret += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return ret;
    }
}