class Solution {
    // the tricky part here is that * can be either ( or )
    // so we can loop the s twice, from left to right and from right to left
    // from left to right, treat * as (, and make sure the counter is >= 0 after loop
    // from right to left, treat * as ), and make sure the counter is >= 0 after loop
    // as long as the counter is >= 0 after two loops, it's definite that there are *s left
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) return true;
        int counter = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '*')
                counter++;
            else {
                if (counter == 0)
                    return false;
                else
                    counter--;
            }
        }
        
        if (counter < 0)
            return false;
        
        counter = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')' || c == '*')
                counter++;
            else {
                if (counter == 0)
                    return false;
                else
                    counter--;
            }
        }
        
        if (counter < 0)
            return false;
        
        return true;
    }
}