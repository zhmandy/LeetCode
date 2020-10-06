class Solution {
    // flip bit by bit
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        int next = N, bit = 1;
        while (next != 0) {
            N = N ^ bit;
            bit = bit << 1;
            next = next >> 1;
        }
        
        return N;
    }
}