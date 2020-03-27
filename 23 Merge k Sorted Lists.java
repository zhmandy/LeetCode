class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        
        ListNode prev = lists[0];
        ListNode current;
        
        for (int i = 1; i < lists.length; i++) {
            current = lists[i];
            
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while (current != null && prev != null) {
                if (current.val <= prev.val) {
                    cur.next = current;
                    current = current.next;
                } else {
                    cur.next = prev;
                    prev = prev.next;
                }
                
                cur = cur.next;
            }
            
            cur.next = prev == null ? current : prev;
            prev = dummy.next;
        }
        
        return prev;
    }
}