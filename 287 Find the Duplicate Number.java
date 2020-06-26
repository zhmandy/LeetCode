class Solution {
    // 我们首先计算mid, 然后我们统计数组中小于等于mid元素的个数k
    // 如果k<=mid的话, 那么说明重复值在[mid+1,n]之间, 否则的话重复值在[1,mid]之间
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        
        int mid = 0;
        int count = 0;
        
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            
            if (count <= mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        count = 0;
        for (int num : nums) {
            if (num == left) {
                count++;
            }
            
            if (count > 1) {
                return left;
            }
        }
        
        return right;
    }
}

class Solution {
    // 将这个问题想成带环的链表, 就变成了检测环的入口
    public int findDuplicate(int[] nums) {
        if (nums.length < 1) return -1;
        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }
}