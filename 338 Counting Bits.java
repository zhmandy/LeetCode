class Solution {
    // 根据2的次方分组
    // 比如在8-16之间的数, 肯定是8+(num-8)
    public int[] countBits(int num) {
        if (num < 0) return new int[]{};
        int bar = 1;
        int[] ret = new int[num + 1];
        
        for (int i = 0; i <= num; i++) {
            if (i == bar * 2) {
                ret[i] = 1;
                bar = bar * 2;
            } else if (i <= bar) {
                ret[i] = i;
            } else {
                ret[i] = ret[bar] + ret[i - bar];
            }
        }
        
        return ret;
    }
}