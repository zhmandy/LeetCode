class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null) {
            // 判断当前结点是否为null再取值
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            
            current.next = new ListNode(sum % 10);
            carry = sum / 10;
            
            // 判断当前结点是否为null再取next
            if (l1 != null) {
                l1 = l1.next;
            }
            
            if (l2 != null) {
                l2 = l2.next;
            }
            current = current.next;
        }
        
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}