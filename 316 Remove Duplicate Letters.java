class Solution {
    // 用string模拟stack
    // 每个字符串和stack顶的字符进行比较, 如果小于并且stack顶的字符串在当前index之后还有, pop head and push the current
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return s;
        
        StringBuilder result = new StringBuilder();
        int[] lastOccurence = new int[26];
        boolean[] used = new boolean[26];
        
        for (int i = 0; i < s.length(); i++) {
            lastOccurence[s.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            // if current char is alreay in use, then ignore the current
            if (used[current - 'a']) continue;
            
            while (result.length() > 0 &&
                   result.charAt(result.length() - 1) > current &&
                   lastOccurence[result.charAt(result.length() - 1) - 'a'] > i) {
                // flag the char first
                used[result.charAt(result.length() - 1) - 'a'] = false;
                result.deleteCharAt(result.length() - 1);
            }
            
            result.append(current);
            used[current - 'a'] = true;
        }
        
        return result.toString();
    }
}