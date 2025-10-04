// Optimal (Monotonic Decreasing Queue)

class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        // Declare a Deque 
        Deque<Integer> dq = new ArrayDeque<>();
        // Declare an 'ans' array of size n - k + 1 as these many no. of maximum values it will store
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            // If deque is not empty and dq's front stores index <= i - k, it means this is out of current window hence remove it from the deque
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst(); // removes element at the front of the queue
            }
            // If deque is not empty and current element is greater than or equal to dq's back then remove the back elements to maintain monotonic decreasing queue
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast();
            }
            // Put the current element at back of the queue
            dq.offerLast(i);
            // If window size has reached k, start inserting the maximum values to the ans
            if (i >= k - 1) {
                // Since first maximum is obtained after window size becomes k, we need to use i - (k - 1) to put the maximum from start of the 'ans' array
                ans[i - (k - 1)] = arr[dq.peekFirst()];
            }
        }
        // Return the ans
        return ans;
}}

// T.C => O(2 * n) = O(n)
// S.C => O(n) + O(n - k + 1) = O(n)
