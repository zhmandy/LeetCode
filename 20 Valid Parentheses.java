class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        Deque<Character> stack = new LinkedList<>();
        stack.push(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c))
                    return false;
            } else {
                stack.push(c);
            }
        }
        
        if (stack.isEmpty()) return true;
        else return false;
    }
}