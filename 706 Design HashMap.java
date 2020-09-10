class MyHashMap {
    
    private class ListNode {
        int key, val;
        ListNode next;
        
        ListNode(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }
    
    private ListNode[] bucket;
    private int capacity;
    private double loadFactor;
    private int count;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        count = 0;
        capacity = 1000;
        loadFactor = 0.75;
        bucket = new ListNode[capacity];
    }
    
    private ListNode find(ListNode node, int key) {
        ListNode prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        // double the capacity if exceeds current one
        if (count == loadFactor * capacity) {
            count = 0;
            capacity *= 2;
            ListNode[] oldBucket = bucket;
            bucket = new ListNode[capacity];
            // rehash
            for (int i = 0; i < oldBucket.length; i++) {
                if (oldBucket[i] == null) continue;
                ListNode current = oldBucket[i].next;
                while (current != null) {
                    this.put(current.key, current.val);
                    current = current.next;
                }
            }
        }
        
        int hash = key % capacity;
        if (bucket[hash] == null)
            bucket[hash] = new ListNode(-1, -1);
        // the preceding node of the one we're looking for, should be not null
        ListNode prev = find(bucket[hash], key);
        if (prev.next == null)
            prev.next = new ListNode(key, value);
        else
            prev.next.val = value;
        count++;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = key % capacity;
        if (bucket[hash] == null) return -1;
        ListNode prev = find(bucket[hash], key);
        return prev.next == null ? -1 : prev.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key % capacity;
        if (bucket[hash] == null) return;
        ListNode prev = find(bucket[hash], key);
        if (prev.next == null) return;
        prev.next = prev.next.next;
        count--;
    }
}