class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int ret = 0;
        int sign = 1;
        
        int start = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                continue;
            if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                if (str.charAt(i) == '-')
                    sign = -1;
                if (i + 1 < str.length()) {
                    start = i + 1;
                    break;
                }
                
                return 0;
            }
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9'))
                return 0;
            else {
                start = i;
                break;
            }
        }
        
        if (start == -1) return 0;
        else {
            while (start < str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9') {
                if (str.charAt(start) == '+' || str.charAt(start) == '-') return 0;
                int pop = (str.charAt(start) - '0') * sign;
                
                if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && pop > 7))
                    return Integer.MAX_VALUE;
                if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && pop < -8))
                    return Integer.MIN_VALUE;

                ret = ret * 10 + pop;
                start++;
            }
            
            return ret;
        }
    }
}