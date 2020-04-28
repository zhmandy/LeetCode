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
        
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                unique.remove(nums[i]);
            } else {
                set.add(nums[i]);
                unique.add(nums[i]);
                queue.add(nums[i]);
            }
        }
        
        // int size = queue.size();
        // for (int i = 0; i < size; i++) {
        //     int num = queue.remove();
        //     if (unique.contains(num)) {
        //         queue.add(num);
        //     }
        // }
    }
    
    public int showFirstUnique() {
        while (queue.size() != 0) {
            int num = queue.peek();
            if (unique.contains(num))
                break;
            queue.remove();
        }
        
        if (queue.size() != 0) {
            return queue.peek();
        } else {
            return -1;
        }
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

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */