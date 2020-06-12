class Solution {
    // counting sort
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int num : nums) {
            count[num]++;
        }
        
        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                nums[idx] = i;
                idx++;
                count[i]--;
            }
        }
    }
}

class Solution {
    // one pass
    // 重点在于先赋值大的, 这样才不会被后面的覆盖
    public void sortColors(int[] nums) {
        int p0 = -1, p1 = -1, p2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[++p2] = 2;
                nums[++p1] = 1;
                nums[++p0] = 0;
            } else if (nums[i] == 1) {
                nums[++p2] = 2;
                nums[++p1] = 1;
            } else {
                nums[++p2] = 2;
            }
        }
    }
}