class Solution {
    // 为了避免从0开始index还是1开始, 在思考的时候我们计数两个数之间的间隙1到n
    // 我们可以对两个数组进行分割, max(nums1Left)<min(nums2Right), max(nums2Left)<min(nums1Right)
    // 满足上述两个条件我们就能够找到中位数(maxLeft or (maxLeft + minRight) / 2)
    // binary search在长度短一些的数组, 并通过定位找到另一个数组的分割, 最后进行条件满足与否的判断
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int mid = 0;
        int idx = 0;
        int left = 0;
        int right = m;
        int target = (m + n + 1) / 2;
        double maxLeft = 0;
        double minRight = 0;
        
        while (left <= right) {
            mid = left + (right - left) / 2;
            idx = target - mid;
            
            if (idx > 0 && mid < m && nums2[idx - 1] > nums1[mid]) {
                left = mid + 1;
            } else if (mid > 0 && idx < n && nums1[mid - 1] > nums2[idx]) {
                right = mid - 1;
            } else {
                if (mid == 0) {
                    maxLeft = (double)nums2[idx - 1];
                } else if (idx == 0) {
                    maxLeft = (double)nums1[mid - 1];
                } else {
                    maxLeft = (double)Math.max(nums1[mid - 1], nums2[idx - 1]);
                }
                break;
            }
        }
        
        if ((m + n) % 2 == 1) {
            return maxLeft;
        }
        if (mid == m) {
            minRight = (double)nums2[idx];
        } else if (idx == n) {
            minRight = (double)nums1[mid];
        } else {
            minRight = (double)Math.min(nums1[mid], nums2[idx]);
        }
        
        return (double)(maxLeft + minRight) / 2;
    }
}