class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        Map<String, List<String>> used = new HashMap<>();
        for (String string : wordDict) {
            set.add(string);
        }
        
        return breakHelper(s, set, used);
    }
    
    private List<String> breakHelper(String s, Set<String> set, Map<String, List<String>> used) {
        if (used.containsKey(s)) return used.get(s);
        if (s.length() == 0) return null;
        
        List<String> result = new LinkedList<>();
        for (int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            List<String> partResult = null;
            if (set.contains(sub)) {
                partResult = breakHelper(s.substring(i), set, used);
                if (partResult == null) {
                    result.add(sub);
                } else {
                    for (String str : partResult) {
                        result.add(sub + " " + str);
                    }
                }
            }
        }
        
        used.put(s, result);
        return result;
    }
}