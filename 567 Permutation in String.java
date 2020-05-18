class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();
        
        for (char ch : s1.toCharArray()) {
            if (pMap.containsKey(ch)) {
                pMap.put(ch, pMap.get(ch) + 1);
            } else {
                pMap.put(ch, 1);
            }
        }
        
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (sMap.containsKey(ch)) {
                sMap.put(ch, sMap.get(ch) + 1);
            } else {
                sMap.put(ch, 1);
            }
            
            // sliding window
            if (i >= s1.length()) {
                ch = s2.charAt(i - s1.length());
                if (sMap.get(ch) == 1) {
                    sMap.remove(ch);
                } else {
                    sMap.put(ch, sMap.get(ch) - 1);
                }
            }
            
            // compare maps
            if (pMap.equals(sMap)) {
                return true;
            }
        }
        
        return false;
    }
}