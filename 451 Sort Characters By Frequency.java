class Solution {
    // sort hashmap w.r.t values
    public String frequencySort(String s) {
        char[] ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        
        for (char c : ch) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        List<Character> chars = new ArrayList<>(map.keySet());
        // ascending map.get(a) - map.get(b) same order as (a, b)
        // descending reversed order as (a, b)
        Collections.sort(chars, (a, b) -> map.get(b) - map.get(a));
        
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            int num = map.get(c);
            for (int i = 0; i < num; i++) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}