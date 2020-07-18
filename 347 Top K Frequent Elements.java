class Solution {
    // use List[] to do the sorting thing
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer>[] frequentList = new LinkedList[nums.length];
        int[] ret = new int[k];
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for (int num : map.keySet()) {
            if (frequentList[map.get(num) - 1] == null)
                frequentList[map.get(num) - 1] = new LinkedList<>();
            frequentList[map.get(num) - 1].add(num);
        }
        
        for (int i = frequentList.length - 1; i >= 0 && k > 0; i--) {
            if (frequentList[i] != null) {
                for (int j = 0; j < frequentList[i].size() && k > 0; j++) {
                    ret[k - 1] = frequentList[i].get(j);
                    k--;
                }
                
            }
        }
        return ret;
    }
}