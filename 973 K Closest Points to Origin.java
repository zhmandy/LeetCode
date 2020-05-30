class Solution {
    // max heap with size K
    // max heap / min heap其实是一样的, 用max heap实现的东西, 可以把数取个相反数,
    // 这样就能够用min heap了, 比如1,2,3,4变成-1,-2,-3,-4
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        
        int[][] ret = new int[K][2];
        for (int i = 0; i < K; i++) {
            ret[i] = pq.poll();
        }
        
        return ret;
    }
}

// quick select
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int left = 0;
        int right = points.length - 1;
        while (left <= right) {
            // the left side of mid is smaller than pivot
            int mid = quickselect(points, left, right);
            if (mid == K) break;
            // adjust the range to select pivot
            if (mid < K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private int quickselect(int[][] points, int left, int right) {
        int[] pivot = points[left];
        while (left < right) {
            while (left < right && compare(points[right], pivot) >= 0) right--;
            points[left] = points[right];
            while (left < right && compare(points[left], pivot) <= 0) left++;
            points[right] = points[left];
        }
        
        points[left] = pivot;
        return left;
    }
    
    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}