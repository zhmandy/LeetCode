class Solution {
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; idx++) {
                sb[idx].append(chars[i++]);
            }
            
            for (int idx = numRows - 2; idx >= 1 && i < len; idx--) {
                sb[idx].append(chars[i++]);
            }
        }
        
        for (int idx = 1; idx < numRows; idx++) {
            sb[0].append(sb[idx]);
        }
        
        return sb[0].toString();
    }
}