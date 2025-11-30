class KthLargest {
    private int K;
    private PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        K = k;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (minHeap.size() < k) {
                minHeap.offer(nums[i]);
            }
            else if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
    }
    
    public int add(int val) {
         if (minHeap.size() < K) {
            minHeap.offer(val);
        }
        else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */