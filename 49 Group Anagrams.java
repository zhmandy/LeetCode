class Solution {
    // 根据字母出现的次数构造string作为key
    // 另一种思路是将string sort作为key
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        
        Map<String, ArrayList<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            for (int i = 0; i < count.length; i++) {
                count[i] = 0;
            }

            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < count.length; i++) {
                sb.append(count[i]);
            }
            String key = sb.toString();
            
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            
            map.get(key).add(str);
        }
        
        return new ArrayList(map.values());
    }
}