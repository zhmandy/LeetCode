class MinStack {

    /** initialize your data structure here. */
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;
    
    public MinStack() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || x <= stack2.peek()) {
            stack2.push(x);
        }
    }
    
    public void pop() {
        if (stack1.peek().equals(stack2.peek())) {
            stack2.pop();
        }
        
        stack1.pop();
    }
    
    public int top() {
        // to prevent NullPointer Exception
        if (stack1.peek() != null) {
            return stack1.peek();
        }
        return Integer.MIN_VALUE;
    }
    
    public int getMin() {
        if (stack2.peek() != null) {
            return stack2.peek();
        }
        return Integer.MAX_VALUE;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */