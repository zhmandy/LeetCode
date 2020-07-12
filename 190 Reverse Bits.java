public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;
            n = n >> 1;
            // do this first to make sure the last loop is correct
            ret = ret << 1;
            ret = ret | bit;
        }
        return ret;
    }
}