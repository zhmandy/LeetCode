class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int sback = 0;
        int tback = 0;
        
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    sback++;
                    i--;
                } else if (sback > 0) {
                    sback--;
                    i--;
                } else {
                    break;
                }
            }
            
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    tback++;
                    j--;
                } else if (tback > 0) {
                    tback--;
                    j--;
                } else {
                    break;
                }
            }
            
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) return false;
            if ((i >= 0) != (j >= 0)) return false;
            i--;
            j--;
        }
        
        return true;
    }
}