class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() < 2) return true;
        
        boolean upperFlag;
        boolean lowerFlag;
        
        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            upperFlag = true;
            lowerFlag = false;
        } else if (Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        } else {
            upperFlag = false;
            lowerFlag = true;
        }
        
        for (int i = 2; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i)) && upperFlag) return false;
            if (Character.isUpperCase(word.charAt(i)) && lowerFlag) return false;
        }
        
        return true;
    }
}