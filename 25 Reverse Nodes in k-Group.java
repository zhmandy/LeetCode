class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = head;
        ListNode fast = moveFast(slow, k);
        
        ListNode prev = dummy;
        while (fast != slow) {
            ListNode tmp = fast.next;
            fast.next = null;
            prev.next = reverseList(slow);
            while (prev.next != null) {
                prev = prev.next;
            }
            prev.next = tmp;
            
            slow = tmp;
            fast = moveFast(slow, k);
        }
        
        return dummy.next;
    }
    
    public ListNode moveFast(ListNode head, int k) {
        if (head == null) return head;
        ListNode fast = head;
        for (int i = 0; i < k - 1; i++) {
            if (fast.next == null) {
                return head;
            } else {
                fast = fast.next;
            }
        }
        return fast;
    }
    
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode current = head;
        
        while (current.next != null) {
            ListNode tmp = current.next;
            current.next = tmp.next;
            tmp.next = head;
            head = tmp;
        }
        
        return head;
    }
}