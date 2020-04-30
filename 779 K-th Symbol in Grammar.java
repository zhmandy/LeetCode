class Solution {
    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        int ret = kthGrammar(N-1, (K+1)/2);
        if (ret == 0)
            return 1 - K%2;
        else
            return K%2;
    }
}