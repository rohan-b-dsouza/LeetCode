// Optimal

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
        // Imagine an hypothetical array (i.e double the current array but hypothetically)
        for (int i = 2 * n - 1; i >= 0; i--) {
            // Get the actual index using modulo n
            int idx = i % n;
            // If stack is not empty and current element is greater than stack's peek, then pop elements
            while (!stack.isEmpty() && nums[idx] >= stack.peek()) {
                stack.pop();
            }
            // If i < n, it means we are now in the actual array phase, hence now start updating 'ans' array
            if (i < n) {
                if (stack.isEmpty()) ans[i] = -1;
                else ans[i] = stack.peek();
            }
            // Push current element to the stack
            stack.push(nums[idx]);
        } 
        // Return the answer
        return ans;
    }
}

// T.C => O(2 * n) for outer loop and in worst case inner loop can also go upto O(2 * n) hence O(4 * n) = O(n)
// S.C => O(2 * n) in worst case for stack + O(n) for the ans = O(n)
