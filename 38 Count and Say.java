class Solution {
    // 设置一个count和pre, 去数当前的字符串, 例如从11到21, 就是"两个1",
    // 当前字符和上一个一样时, count++, 当出现不一样字符的时候, 记录count个pre
    public String countAndSay(int n) {
        if (n < 0) return "";

        int iter = 0;
        String str = "1";
        
        while (iter < n - 1) {
            int count = 0;
            char pre = '.';
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < str.length(); i++) {
                if (pre == '.' || pre == str.charAt(i)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(pre);
                    count = 1;
                }
                pre = str.charAt(i);
            }
            
            sb.append(count);
            sb.append(pre);
            str = sb.toString();
            iter++;
        }
        
        return str;
    }
}