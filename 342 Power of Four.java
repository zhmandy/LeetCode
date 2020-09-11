class Solution {
    // bit manipulation
    // distinguish odd power of two and even power of two
    // power of two (num & (num - 1)) == 0
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
    }
}