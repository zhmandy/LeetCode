class Solution {
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

// recursion
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode ret = reverseList(head.next);
        
        head.next.next = head;
        head.next = null;
        
        return ret;
    }
}