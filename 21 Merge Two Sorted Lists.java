class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (l1 != null && l2 != null) {
            int val;
            if (l1.val <= l2.val) {
                val = l1.val;;
                l1 = l1.next;
            } else {
                val = l2.val;
                l2 = l2.next;
            }
            
            current.next = new ListNode(val);
            current = current.next;
        }
        
        if (l1 != null) {
            current.next = l1;
        }
        
        if (l2 != null) {
            current.next = l2;
        }
        
        return dummy.next;
    }
}