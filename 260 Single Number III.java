class Solution {
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        // bitmask will be the XOR of two numbers with at least one 1
        for (int num : nums) bitmask ^= num;
        
        // to find the right-most 1 bit as the difference between two numbers
        int diff = bitmask & (-bitmask);
        
        int x = 0;
        // two same number will get zero, this op gets one of the two single number
        for (int num : nums) if ((num & diff) != 0) x ^= num;
        
        return new int[]{x, bitmask ^ x};
    }
}