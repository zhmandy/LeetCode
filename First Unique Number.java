// FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
// int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
// void add(int value) insert value to the queue.
class FirstUnique {
    
    private Queue<Integer> queue;
    private Set<Integer> set;
    private Set<Integer> unique;

    public FirstUnique(int[] nums) {
        queue = new LinkedList<>();
        set = new HashSet<>();
        unique = new HashSet<>();
        
        for (int num : nums) {
            add(num);
        }
    }
    
    public int showFirstUnique() {
        while (queue.size() != 0) {
            int num = queue.peek();
            if (unique.contains(num))
                break;
            queue.remove();
        }
        
        return (queue.size() == 0) ? -1 : queue.peek();
    }
    
    public void add(int value) {
        if (set.contains(value)) {
            unique.remove(value);
        } else {
            set.add(value);
            unique.add(value);
            queue.add(value);
        }
        
        // int size = queue.size();
        // for (int i = 0; i < size; i++) {
        //     int num = queue.remove();
        //     if (unique.contains(num)) {
        //         queue.add(num);
        //     }
        // }
    }
}