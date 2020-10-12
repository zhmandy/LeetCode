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
        
        ArrayList<Integer>[] indexStorage = new ArrayList[26];
        for (int i = 0; i < A.length(); i++) {
            char current = A.charAt(i);
            if (indexStorage[current - 'a'] == null) indexStorage[current - 'a'] = new ArrayList<>();
            indexStorage[current - 'a'].add(i);
        }
        
        char[] chs = A.toCharArray();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                char target = B.charAt(i);
                if (indexStorage[target - 'a'] == null) return false;
                else {
                    ArrayList<Integer> idx = indexStorage[target - 'a'];
                    for (int j = 0; j < idx.size(); j++) {
                        int index = idx.get(j);
                        swap(chs, i, index);
                        if (B.equals(new String(chs))) return true;
                        swap(chs, index, i);
                    }
                }
            }
        }
        
        return false;
    }
}