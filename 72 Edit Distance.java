class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0 && len2 == 0) return 0;
        
        int[][] dis = new int[len1 + 1][len2 + 2];
        // match string with empty string, just delete all the chars
        for (int i = 0; i <= len1; i++) dis[i][0] = i;
        for (int j = 0; j <= len2; j++) dis[0][j] = j;
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // if current char is the same, consider the smallest among the following:
                // 1. dis[i-1][j-1], previous string is the same too
                // 2. dis[i-1][j]+1/dis[i][j-1]+1, previous string: one delete to match the other
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dis[i][j] = Math.min(Math.min(dis[i - 1][j - 1], dis[i - 1][j] + 1), dis[i][j - 1] + 1);
                // if current char is not the same, consider the smallest
                // different case: dis[i-1][j-1] + 1, replace the current one to match
                } else {
                    dis[i][j] = Math.min(Math.min(dis[i - 1][j - 1] + 1, dis[i - 1][j] + 1), dis[i][j - 1] + 1);
                }
            }
        }
        
        return dis[len1][len2];
    }
}