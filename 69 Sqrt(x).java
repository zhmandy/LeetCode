class Solution {
    // 用二分法来找到最接近的整数
    public int mySqrt(int x) {
        if (x < 2) return x;
        
        int left = 2;
        int right = x / 2;
        int mid;
        
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right;
    }
}