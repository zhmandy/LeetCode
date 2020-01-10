class Solution {
    // 用移位来实现乘法, 再用被除数去减, 当余数小于除数的时候结束
    // 移位只能实现2的指数次的乘法, 其他数字的倍数无法实现
    // 比如32/3, 3一次次左移到3*2^4=48 > 32, 发现超过了, 所以回退一个当前只左移到3*2^3=24,
    // 剩下的8, 重新开始计算, 结束条件是被除数小于除数, 此时结果就是8+2=10
    // **这题还需要仔细考虑边界条件, 包括Integer的最小值直接取反会超过Integer最大值, 还有其他溢出情况等
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) return Integer.MIN_VALUE;
            else if (divisor == -1) return Integer.MAX_VALUE;
        }
        
        long divd = (long)dividend;
        long divs = (long)divisor;
        int sign = 1;
        if (divisor < 0) {
            divs = -divs;
            sign = -sign;
        }
        if (dividend < 0) {
            divd = -divd;
            sign = -sign;
        }
        
        int result = 0;
        while (divd >= divs) {
            int shift = 0;
            while (divd >= (divs << shift)) {
                shift++;
            }
            result += (1 << (shift - 1));
            divd -= (divs << (shift - 1));
        }
        
        return result * sign;
    }
}