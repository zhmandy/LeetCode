class Solution {
    //  if s[j]s[j] have a duplicate in the range [i, j)[i,j) with index j'
    // we don't need to increase ii little by little. We can skip all the elements in the range [i, j'] and let i to be j' + 1
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int n = s.length();
        
        for (int i = 0, j = 0; j < n; j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c));
            }
            
            maxLen = Math.max(maxLen, j - i + 1);
            map.put(c, j + 1);
        }
        
        return maxLen;
    }
}