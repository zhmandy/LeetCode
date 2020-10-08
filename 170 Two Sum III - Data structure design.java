class TwoSum {
    
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int target = value - entry.getKey();
            if (target == entry.getKey()) {
                if (entry.getValue() > 1) {
                    return true;
                }
            } else {
                if (map.containsKey(target)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}