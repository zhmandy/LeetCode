class Solution {
    public String stringShift(String s, int[][] shift) {
        int ops = 0;
        for (int i = 0; i < shift.length; i++) {
            if (shift[i][0] == 0) {
                ops -= shift[i][1];
            } else {
                ops += shift[i][1];
            }
        }
        
        ops = ops % s.length();
        if (ops > 0) {
            String first = s.substring(0, s.length() - ops);
            String second = s.substring(s.length() - ops);
            return second.concat(first);
        } else if (ops < 0) {
            String first = s.substring(0, -ops);
            String second = s.substring(-ops);
            return second.concat(first);
        } else {
            return s;
        }
    }
}