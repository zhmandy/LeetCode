class Solution {
    // repeat every 14 times
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (N == 0) return cells;
        
        N = N % 14;
        // important step
        if (N == 0) N = 14;
        
        int[] prev = cells;
        int[] current = new int[8];
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 6; j++) {
                if (prev[j - 1] == prev[j + 1]) {
                    current[j] = 1;
                } else {
                    current[j] = 0;
                }
            }
            
            System.arraycopy(current, 0, prev, 0, 8);
        }
        
        return current;
    }
}