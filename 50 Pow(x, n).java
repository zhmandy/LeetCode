class Solution {
    // 将n二分, 每二分一次就是执行x*x一次
    // Integer的MAX值的绝对值是比Integer的MIN值的绝对值要小1, 将负数转成正数先乘一次x再转
    public double myPow(double x, int n) {
        if (x == 1 || n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) return 1 / (x * myPow(x, -(n + 1)));
        
        double result = 1;
        while (n > 1) {
            if (n % 2 == 1) result = result * x;
            n = n / 2;
            x = x * x;
        }
        
        return result * x;
    }
}