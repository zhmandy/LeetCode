class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        int carry = 1;
        
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = 0;
            
            if (digits[i] > 9) {
                carry = 1;
                digits[i] = 0;
            }
        }
        
        if (carry == 1) {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            return ret;
        } else {
            return digits;
        }
    }
}