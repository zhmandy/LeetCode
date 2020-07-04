class Solution {
    public int arrangeCoins(int n) {
        int ret = 0;
        while (n > 0) {
            ret++;
            if (n - ret >= 0) {
                n = n - ret;
            } else {
                ret--;
                break;
            }
        }
        return ret;
    }
}