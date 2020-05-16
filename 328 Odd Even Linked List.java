class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode oddHead = odd;
        ListNode evenHead = even;
        int idx = 1;
        
        while (head != null) {
            if (idx % 2 == 1) {
                odd.next = head;
                head = head.next;
                odd = odd.next;
            } else if (idx % 2 == 0) {
                even.next = head;
                head = head.next;
                even = even.next;
            }
            
            idx++;
        }
        
        odd.next = null;
        even.next = null;
        
        odd.next = evenHead.next;
        return oddHead.next;
    }
}