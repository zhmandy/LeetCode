class Solution {
    public int fib(int N) {
        if (N <= 1) return N;
        return cache(N);
    }
    
    private int cache(int N) {
        int[] mem = new int[N + 1];
        mem[1] = 1;
        
        for (int i = 2; i <= N; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        
        return mem[N];
    }
}