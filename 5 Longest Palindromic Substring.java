class Solution {
    /*
    0.dynamic programming
    1.思路: 当找到字符串一头一尾的字符相等时, 看两头各缩进一个位置的字符是否相等
            回文串相当于轴对称, 可以在一个字符的位置对称, 也能够在两个相同字符的中间对称, 因此在初始化的时候有两种情况
            init: 每个单独的字符都是回文串, 初始化为true; 当有连续两个字符相等的情况, 也需要初始化为true
            function: 当首尾两个字符相等, 且缩进一个位置的字符相等

    review: 这道题使用的这种方式是很重要的模板, 需要好好记住, 使用一个二维boolean来辅助判断
    */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int len = s.length();
        
        int start = 0;
        int length = 1;
        
        boolean[][] result = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            result[i][i] = true;
            start = i;
        }
        
        for (int i = 0; i + 1 < len; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                result[i][i + 1] = true;
                start = i;
                length = 2;
            }
        }
        
        for (int l = 2; l < len; l++) {
            for (int i = 0; i + l < len; i++) {
                if (s.charAt(i) != s.charAt(i + l)) {
                    result[i][i + l] = false;
                } else {
                    result[i][i + l] = result[i + 1][i + l - 1];
                    if (result[i][i + l]) {
                        start = i;
                        length = l + 1;
                    }
                }
            }
        }
        
        return s.substring(start, start + length);
    }
}