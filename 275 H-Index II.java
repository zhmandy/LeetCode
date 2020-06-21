class Solution {
    // 这道题的目的是找一个citations.length - mid最大的值
    // 然后返回这个长度
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int left = 0;
        int right = citations.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= citations.length - mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (citations[left] >= citations.length - left) {
            return citations.length - left;
        } else if (citations[right] >= citations.length - right) {
            return citations.length - right;
        }
        
        return 0;
    }
}