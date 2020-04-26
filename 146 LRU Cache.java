class LRUCache {
    private class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
    }
    
    private Map<Integer, ListNode> map = new HashMap<>();
    private ListNode head;
    private ListNode tail;
    private int totalInCache;
    private int maxCapacity;
    
    private ListNode popTail() {
        if (tail.prev == head) return null;
        ListNode node = tail.prev;
        removeFromList(node);
        return node;
    }
    
    private void removeFromList(ListNode node) {
        if (node == null) return;
        ListNode pprev = node.prev;
        ListNode nnext = node.next;
        
        pprev.next = nnext;
        nnext.prev = pprev;
    }
    
    private void addToFront(ListNode node) {
        if (node == null) return;
        node.next = head.next;
        node.prev = head;
        
        head.next.prev = node;
        head.next = node;
    }
    
    private void moveToFront(ListNode node) {
        removeFromList(node);
        addToFront(node);
    }

    public LRUCache(int capacity) {
        totalInCache = 0;
        maxCapacity = capacity;
        
        head = new ListNode();
        tail = new ListNode();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null)
            return -1;
        
        moveToFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        ListNode node = map.get(key);
        if (node == null) {
            ListNode newNode = new ListNode();
            newNode.val = value;
            newNode.key = key;
            
            addToFront(newNode);
            map.put(key, newNode);
            totalInCache++;
            
            if (totalInCache > maxCapacity) {
                ListNode delNode = popTail();
                map.remove(delNode.key);
                totalInCache--;
            }
        } else {
            node.val = value;
            moveToFront(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */