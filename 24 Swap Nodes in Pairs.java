class Solution {
    public ListNode swapPairs(ListNode head) {
        // check if head is null at the beginning
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // three pointers to do swapping
        ListNode current = head;
        ListNode prev = dummy;
        ListNode next;
        
        if (current.next == null) {
            return head;
        } else {
            next = current.next;
        }
        
        while (current != null && next != null) {
            current.next = next.next != null ? next.next : null;
            next.next = current;
            prev.next = next;
            
            prev = current;
            current = current.next;
            next = current != null ? current.next : null;
            
        }
        
        return dummy.next;
    }
}

// recursion
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        return swapHelper(head);
    }
    
    private ListNode swapHelper(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ret = swapHelper(head.next.next);
        
        ListNode tmp = head.next;
        head.next = ret;
        tmp.next = head;
        head = tmp;
        
        return head;
    }
}