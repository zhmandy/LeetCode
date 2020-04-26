class Solution {
    // for AND operation, if there is one zero in a column, the result is 0
    // so the problem changes to find the common prefix
    // the common prefix of all these bit string is also the common prefix between the starting and ending numbers
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        
        return m << shift;
    }
}