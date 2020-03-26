class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        int count = 0;
        
        while (ptr2 != null) {
            // 检查快慢指针之间差几个
            if (count >= n + 1) {
                ptr1 = ptr1.next == null ? null : ptr1.next;
            }
            
            ptr2 = ptr2.next == null ? null : ptr2.next;
            count++;
        }
        
        // corner case: n == length
        if (count < n + 1) {
            head = head.next;
        } else {
            ptr1.next = ptr1.next.next;
        }
        return head;
    }
}