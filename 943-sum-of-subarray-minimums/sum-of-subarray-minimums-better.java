// Better (Monotonic Increasing Stack)

class Solution {
    public int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // If stack is not empty and stack's peek is greater than current element, pop the stack's top
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            // If stack is empty then set PSE as -1, to calculate correct 'left'
            if(stack.isEmpty()) pse[i] = -1; 
            // Else add stack's top as PSE of current element
            else pse[i] = stack.peek();
            // Push current element's index to the stack
            stack.push(i);
        }
        // Return the answer
        return pse;
    }
    public int[] findNSE(int[] arr) {
        int n = arr.length;
       int[] nse = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            // If stack is not empty and stack's peek is greater than or equal to current element, then pop the stack's top
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            // If stack is empty, then set NSE as n for calculating correct 'right'
            if (stack.isEmpty()) nse[i] = n;
            // Else NSE of the current element is stack's top
            else nse[i] = stack.peek();
            // Push current element's index to the stack
            stack.push(i);
        }
        // Return the list
        return nse;
    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        final int MOD = 1000000007;
        // Get PSE and NSE arrays of 'arr'
        int[] pse = findPSEE(arr);
        int[] nse = findNSE(arr);
        // Initialize sum to zero
        long sum = 0;
        for (int i = 0; i < n; i++) {
             // Get subarray of left type
            int left = i - pse[i];
            // Get subarrays of right type
            int right = nse[i] - i;
            // Calculate total subarrays with current element as the minimum element
            long contrib = ((long) left * right % MOD) * arr[i] % MOD;
            // Update the sum
            sum = (sum + contrib) % MOD;
        } 
        // Return the sum
        return (int) sum;
    }
}

// T.C => O(2 * n) + O(2 * n) + O(n) = O(5 * n) = O(n)
// S.C => O(4 * n) = O(n)
