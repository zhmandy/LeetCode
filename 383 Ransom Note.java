class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                if (count > 0) {
                    map.put(c, count - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        return true;
    }
}