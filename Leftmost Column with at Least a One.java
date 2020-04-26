/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    // Imagine there is a pointer p(x, y) starting from top right corner.
    // p can only move left or down.
    // If the value at p is 0, move down. If the value at p is 1, move left.
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int ret = -1;
        List<Integer> dim = binaryMatrix.dimensions();
        
        int i = 0;
        int j = dim.get(1) - 1;
        
        while (i < dim.get(0) && j >= 0) {
            if (binaryMatrix.get(i, j) == 1) {
                ret = j;
                j--;
            } else {
                i++;
            }
        }
        
        return ret;
    }
}