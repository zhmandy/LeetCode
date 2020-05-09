class Solution {
    // 乘法的时候注意类型变量的边界
    // 用long不用int
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        
        long left = 2;
        long right = num / 2;
        while (left + 1 < right) {
            long x = left + (right - left) / 2;
            if (x * x == num)
                return true;
            if (x * x > num)
                right = x - 1;
            else
                left = x + 1;
        }
        
        if (left * left == num)
            return true;
        if (right * right == num)
            return true;
        
        return false;
    }
}