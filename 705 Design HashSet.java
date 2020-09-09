class MyHashSet {
    private List<Integer>[] bucket;
    private int capacity;
    private double loadFactor;
    private int count;

    /** Initialize your data structure here. */
    public MyHashSet() {
        capacity = 1000;
        count = 0;
        // once the storage exceeds the 75%, double the capacity and rehash
        loadFactor = 0.75;
        bucket = new LinkedList[capacity];
    }
    
    public void add(int key) {
        if (this.contains(key)) return;
        // double the size and rehash
        if (count == capacity * loadFactor) {
            count = 0;
            capacity *= 2;
            List<Integer>[] oldBucket = bucket;
            bucket = new LinkedList[capacity];
            for (int i = 0; i < oldBucket.length; i++) {
                List<Integer> line = oldBucket[i];
                if (line != null) {
                    for (int value : line) this.add(value);
                }
            }
        }
        
        int hash = key % capacity;
        if (bucket[hash] == null) bucket[hash] = new LinkedList<>();
        bucket[hash].add(key);
        count++;
    }
    
    public void remove(int key) {
        int hash = key % capacity;
        List<Integer> currentLine = bucket[hash];
        if (currentLine != null) {
            Iterator<Integer> iterator = currentLine.iterator();
            while(iterator.hasNext()) {
                if (key == iterator.next()) {
                    iterator.remove();
                    count--;
                }
            }
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = key % capacity;
        List<Integer> currentLine = bucket[hash];
        if (currentLine != null) {
            Iterator<Integer> iterator = currentLine.iterator();
            while(iterator.hasNext()) {
                if (key == iterator.next()) return true;
            }
        }
        
        return false;
    }
}