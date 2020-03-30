class Solution {
    // if there is no *, just check match one by one
    // if there are *s, they will be in s.substring(1)
    // we may ignore this part of the pattern, or delete a matching character in the text
    // If we have a match on the remaining strings after any of these operations, then the initial inputs matched
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        
        boolean first = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (first && isMatch(s.substring(1), p));
        } else {
            return first && isMatch(s.substring(1), p.substring(1));
        }
    }
}