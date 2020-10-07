class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 1;
        
        while (head.next != null) {
            len++;
            head = head.next;
        }

        // form a circle
        head.next = dummy.next;
        
        len = len - k % len;
        head = dummy.next;
        
        while (len > 1) {
            len--;
            head = head.next;
        }
        
        dummy.next = head.next;
        head.next = null;
        
        return dummy.next;
    }
}