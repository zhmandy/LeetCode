class Solution {
    // store two HashMaps and compare it
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return new ArrayList();
        
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> pMap = new HashMap<>();
        
        for (char ch : p.toCharArray()) {
            if (pMap.containsKey(ch)) {
                pMap.put(ch, pMap.get(ch) + 1);
            } else {
                pMap.put(ch, 1);
            }
        }
        
        List<Integer> ret = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (sMap.containsKey(ch)) {
                sMap.put(ch, sMap.get(ch) + 1);
            } else {
                sMap.put(ch, 1);
            }
            
            // sliding window
            if (i >= p.length()) {
                ch = s.charAt(i - p.length());
                if (sMap.get(ch) == 1) {
                    sMap.remove(ch);
                } else {
                    sMap.put(ch, sMap.get(ch) - 1);
                }
            }
            
            // compare maps
            if (pMap.equals(sMap)) {
                ret.add(i - p.length() + 1);
            }
        }
        
        return ret;
    }
}