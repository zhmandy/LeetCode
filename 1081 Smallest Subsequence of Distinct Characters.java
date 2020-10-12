class Solution {
    public String smallestSubsequence(String s) {
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
