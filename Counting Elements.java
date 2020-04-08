class Solution {
    // use hashset to store elements
    // loop again to count
    public int countElements(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        
        for (int num : arr) {
            set.add(num);
        }
        
        int ret = 0;
        for (int num : arr) {
            if (set.contains(num + 1)) {
                ret++;
            }
        }
        
        return ret;
    }
}