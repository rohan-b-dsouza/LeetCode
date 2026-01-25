// Time - Optimal (Monotonic Stack + Contribution Technique)

// Logic:
// Treat each element as the minimum of a subarray.
// Using a monotonic increasing stack, find Previous Smaller Element (PSE)
// and Next Smaller Element (NSE) to determine the widest subarray where
// nums[idx] is the minimum.

// For each such range [left..right], check if it contains index k.
// If yes, compute:
// score = nums[idx] * (right - left + 1)

// This is equivalent to Largest Rectangle in Histogram,
// with the extra constraint that the rectangle must include k.

// Time Complexity: O(n)
// Each index is pushed and popped at most once.

// Space Complexity: O(n)
// Stack used to maintain monotonic order.


class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int idx = stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int left = pse + 1; int right = nse - 1;
                if (left > k || right < k) continue;
                ans = Math.max(nums[idx] * 1L * (right - left + 1), ans); 
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            int left = pse + 1; int right = nse - 1;
            if (left > k || right < k) continue;
            ans = Math.max(nums[idx] * 1L * (right - left + 1), ans); 
        } 
        return (int) ans;
    }
}

// T.C => O(2 * n) = O(n)
// S.C => O(n)
