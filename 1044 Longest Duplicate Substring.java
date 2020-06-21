class Solution {
    public String longestDupSubstring(String S) {
        int len = S.length();
        
        // convert string to int array for constant time slice
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = S.charAt(i) - 'a';
        }
        
        // base value for rolling hash
        int base = 26;
        // modulus value for rolling hash to avoid overflow
        long modulus = (long)Math.pow(2, 32);
        
        int left = 1;
        int right = len;
        // if length x works, there is no need to check length x - 1
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int ret = dupSearch(mid, base, modulus, len, nums);
            if (ret != -1) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        int ret = dupSearch(right, base, modulus, len, nums);
        if (ret != -1) {
            return S.substring(ret, ret + right);
        }
        
        ret = dupSearch(left, base, modulus, len, nums);
        if (ret != -1) {
            return S.substring(ret, ret + left);
        }
        
        return "";
    }
    
    private int dupSearch(int subLen, int base, long modulus, int len, int[] nums) {
        long hash = 0;
        for (int i = 0; i < subLen; i++) {
            hash = (hash * base + nums[i]) % modulus;
        }
        
        HashSet<Long> set = new HashSet<>();
        set.add(hash);
        // constant value to be used often: base**subLen % modulus
        long baseL = 1;
        for (int i = 1; i <= subLen; i++) {
            baseL = (baseL * base) % modulus;
        }
        
        for (int i = 1; i < len - subLen + 1; i++) {
            // compute rolloing hash in O(1)
            hash = (hash * base - nums[i - 1] * baseL % modulus + modulus) % modulus;
            hash = (hash + nums[i + subLen - 1]) % modulus;
            
            if (set.contains(hash)) return i;
            set.add(hash);
        }
        return -1;
    }
}