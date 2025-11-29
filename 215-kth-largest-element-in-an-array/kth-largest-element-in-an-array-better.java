// Better

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // Minheap 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // First, put the first k elements into the PQ
        for (int i = 1; i <= k; i++) {
            minHeap.offer(nums[i - 1]);
        }
      // Now, iterate over the remaining n - k elements (This step ensures that the PQ atlast remains with 'k' largest elements with kth largest element being the minimum element in the PQ)
        for (int i = k; i < n; i++) {
            // If element is greater than minimum element in the PQ
            if (nums[i] > minHeap.peek()) {
                // Remove the minimum element
                minHeap.poll();
                // Put current element to the PQ
                minHeap.offer(nums[i]);
            } 
        }
        // Return the kth largest element
        return minHeap.peek();
    }
}

// T.C => O(k * log(k)) + O((n - k) * log(k)) = O(n * log(k))
// S.C => O(k)
