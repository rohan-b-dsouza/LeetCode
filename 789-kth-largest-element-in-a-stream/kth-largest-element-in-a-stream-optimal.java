// Optimal

class KthLargest {
    // Create K and a MINHEAP PQ 'minheap'
    private int K;
    private PriorityQueue<Integer> minHeap;
    public KthLargest(int k, int[] nums) {
        // Define the minHeap
        minHeap = new PriorityQueue<>();
        K = k; // Assign k to K
        int n = nums.length;
        // Iterate over the array
        for (int i = 0; i < n; i++) {
            // If minHeap size is less than k, keep adding elements in the nums array
            if (minHeap.size() < k) {
                minHeap.offer(nums[i]);
            }
            // Else if minHeap has k elements, if current element is greater than minHeap's top then replace it with this new element
            else if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
    }
    public int add(int val) {
         // If minHeap is smaller than K (this happens when initially n < k || n == 0)
         if (minHeap.size() < K) {
            // Add val to the minHeap
            minHeap.offer(val);
        }
        // Else if val is greater than minHeap's top
        else if (val > minHeap.peek()) {
            // Replace minHeap's top with val
            minHeap.poll();
            minHeap.offer(val);
        }
        // Return minHeap's top
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

// T.C => O(n * log(k))
// S.C => O(k)
