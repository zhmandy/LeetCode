class Solution {
    private Node dfsHelper(Node current, Node head) {
        if (head == null) return current;
        current.next = head;
        head.prev = current;
        
        // save the next node
        // otherwise the head will be changed during recursion
        Node tmpNext = head.next;
        
        // need to know the tail of child list
        Node tail = dfsHelper(head, head.child);
        head.child = null;
        
        return dfsHelper(tail, tmpNext);
    }
    
    public Node flatten(Node head) {
        if (head == null) return head;
        Node dummy = new Node(0, null, head, null);
        dfsHelper(dummy, head);
        dummy.next.prev = null;
        return dummy.next;
    }
}