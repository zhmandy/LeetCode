class Solution {
    // calculate max, min, sum of each input
    // 1.如果数组全是正数，那么最大和就是数组所有元素的和 sum
    // 2.如果数组有正有负，首先考虑没有环时，我们可以求出最大子树组和 max，有环时，想要子数组和最大，我们需要从数组中删除一段负数，这样剩余的数组和才能更大。想要剩余的子数组和最大，那么删掉的那一段负数就应该最小，也就是最小子数组和min
    // 3.所以如果min是负数，最终我们只需要比较 max 和sum-min的值谁大就可以了，如果min是正数，那么最大值一定是sum，如果sum==min则说明最小子数组是数组本身，这个时候应该是max最大
    public int maxSubarraySumCircular(int[] A) {
        if (A == null || A.length == 0) return 0;
        int maxTillHere = A[0];
        int maxInTotal = A[0];
        int minTillHere = A[0];
        int minInTotal = A[0];
        int sum = A[0];
        
        for (int i = 1; i < A.length; i++) {
            sum += A[i];
            // if maxTillHere is negative, discard
            if (maxTillHere + A[i] > A[i]) {
                maxTillHere += A[i];
            } else {
                maxTillHere = A[i];
            }
            
            maxInTotal = Math.max(maxInTotal, maxTillHere);
            
            if (minTillHere + A[i] < A[i]) {
                minTillHere += A[i];
            } else {
                minTillHere = A[i];
            }
            
            minInTotal = Math.min(minInTotal, minTillHere);
        }
        
        
        if (sum == minInTotal) return maxInTotal;
        return Math.max(sum - minInTotal, maxInTotal);
    }
}