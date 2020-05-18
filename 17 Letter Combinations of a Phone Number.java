class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits.length() == 0) return ret;
        
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combineHelper(map, ret, digits, "");
        return ret;
    }
    
    private void combineHelper(String[] map, List<String> ret, String digits, String current) {
        if (current.length() == digits.length()) {
            ret.add(current);
            return;
        }
        
        String newString = map[digits.charAt(current.length()) - '0'];
        for (int i = 0; i < newString.length(); i++) {
            combineHelper(map, ret, digits, current + newString.charAt(i));
        }
    }
}