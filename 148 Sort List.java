class Solution {
    public ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = midPrev == null ? head : midPrev.next;
            head = head.next.next;
        }
        
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
    
    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        else if (list1.val < list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list2.next, list1);
            return list2;
        }
    }
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }
}