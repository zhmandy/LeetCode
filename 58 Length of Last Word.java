class Solution {
    public int lengthOfLastWord(String s) {
        int ret = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && ret == 0)
                continue;
            if (s.charAt(i) == ' ')
                break;
            ret += 1;
        }
        return ret;
    }
}