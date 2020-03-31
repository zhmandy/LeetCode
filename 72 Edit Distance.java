class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // state: dis[i][j]: distance between word1(0, i) and word2(0, j), inclusive
        int[][] dis = new int[m+1][n+1];
        
        // init: [0][j], [i][0] are all 0
        for (int i = 0; i <= m; i++) dis[i][0] = i;
        for (int j = 0; j <= n; j++) dis[0][j] = j;
        
        // function: if [i] == [j] dis[i][j] = min(dis[i-1][j-1], dis[i-1][j]+1, dis[i][j-1]+1)
        //           else dis[i][j] = min(dis[i-1][j-1]+1, dis[i-1][j]+1, dis[i][j-1]+1)
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dis[i][j] = Integer.MAX_VALUE;
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dis[i][j] = Math.min(dis[i-1][j-1], dis[i-1][j]+1);
                    dis[i][j] = Math.min(dis[i][j], dis[i][j-1]+1);
                } else {
                    dis[i][j] = Math.min(dis[i-1][j-1]+1, dis[i-1][j]+1);
                    dis[i][j] = Math.min(dis[i][j], dis[i][j-1]+1);
                }
            }
        }
        
        return dis[m][n];
    }
}