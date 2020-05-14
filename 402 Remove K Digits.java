class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>();
        
        // greedy: if current is smaller than the left neighbor, delete the left neighbor
        for (char ch : num.toCharArray()) {
            while (stack.size() > 0 && k > 0 && stack.peekLast() > ch) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(ch);
        }
        
        // if k still > 0, meaning the rest is nondecreasing, just delete from right
        for (int i = 0; i < k; i++) {
            stack.removeLast();
        }
        
        StringBuilder ret = new StringBuilder();
        // deal with leading zero
        boolean leadZero = true;
        for (char ch : stack) {
            if (leadZero && ch == '0')
                continue;
            leadZero = false;
            ret.append(ch);
        }
        
        // deal with empty string
        if (ret.length() == 0)
            return "0";
        return ret.toString();
    }
}