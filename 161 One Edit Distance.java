class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        
        // assume slen <= tlen
        if (slen > tlen) {
            return isOneEditDistance(t, s);
        }
        
        // no way there is one edit distance
        if (slen - tlen > 1) {
            return false;
        }
        
        // check char one by one
        for (int i = 0; i < slen; i++) {
            // found a different one
            if (s.charAt(i) != t.charAt(i)) {
                if (slen == tlen) {
                    // if same length, check if this is the only difference
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    // check if the rest is the same
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        
        // check the difference between s, t is the last char
        return slen + 1 == tlen;
    }
}