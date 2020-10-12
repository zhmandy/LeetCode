class Solution {
    public void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
    
    public boolean buddyStrings(String A, String B) {
        if (A.length() == 0 || B.length() == 0) return false;
        else if (A.length() != B.length()) return false;
        
        if (A.equals(B)) {
            boolean[] checkDuplicate = new boolean[26];
            for (int i = 0; i < A.length(); i++) {
                if (checkDuplicate[A.charAt(i) - 'a']) {
                    return true;
                }
                checkDuplicate[A.charAt(i) - 'a'] = true;
            }
            return false;
        }
        
        List<Integer> dif = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i) {
            if (A.charAt(i) != B.charAt(i)) {
                dif.add(i);
            }
        }
        
        return dif.size() == 2 &&
            A.charAt(dif.get(0)) == B.charAt(dif.get(1)) &&
            A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }
}