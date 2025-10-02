// Optimal

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
      if (stack.isEmpty()) pse[i] = -1;
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
      // If stack is not empty and stack's peek is greater than or equal to current element, then
      // pop the stack's top
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
  
  public long sumSubarrayMins(int[] arr) {
        int n = arr.length;
        // Get PSE and NSE arrays of 'arr'
        int[] pse = findPSEE(arr);
        int[] nse = findNSE(arr);
        // Initialize sum to zero
        long sum = 0;
        for (int i = 0; i < n; i++) {
            // Count subarray of left type
            int left = i - pse[i];
            // Count subarrays of right type
            int right = nse[i] - i;
            // Update the sum
            sum += (long) left * right * arr[i];
        }
        // Return the sum
        return sum;
    }

  public int[] findPGEE(int[] arr) {
    int n = arr.length;
    int[] ans = new int[n];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      // If stack is not empty and stack's peek is smaller than or equal to current element, then
      // pop stack's pop
      while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
        stack.pop();
      }
      // If stack is empty, set -1 as PGEE for calculating correct 'left'
      if (stack.isEmpty()) ans[i] = -1;
      // Else stack's top is the PGE of current element
      else ans[i] = stack.peek();
      // Push the current element's index to the stack
      stack.push(i);
    }
    // Return the list
    return ans;
  }

  public int[] findNGE(int[] arr) {
    int n = arr.length;
    int[] ans = new int[n];
    Deque<Integer> stack = new ArrayDeque<>();
    // Traverse from backwards
    for (int i = n - 1; i >= 0; i--) {
      // If stack is not empty and current element >= stack's peek, then pop element
      while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
        stack.pop();
      }
      // If stack is empty then set NGE as n, to calculate correct 'right'
      if (stack.isEmpty()) ans[i] = n;
      // Else NGE of current element is stack's peek
      else ans[i] = stack.peek();
      // Push the current element's index on the stack
      stack.push(i);
    }
    // Return ans
    return ans;
  }

  public long sumSubarrayMaxs(int[] arr) {
    int n = arr.length;
    // Get the pgee and nge array of 'arr'
    int[] pgee = findPGEE(arr);
    int[] nge = findNGE(arr);
    long sum = 0;
    for (int i = 0; i < n; i++) {
      // Count subarrays of 'left' type
      int left = i - pgee[i];
      // Count subarrays of 'right' type
      int right = nge[i] - i;
      // Update the sum
      sum += (long) left * right * arr[i]; 
    }
    // Return the sum
    return sum;
  }

  public long subArrayRanges(int[] nums) {
    int n = nums.length;
    // Compute the answer by subtracting sum of subarray minimums from sum of subarray maximums
    return sumSubarrayMaxs(nums) - sumSubarrayMins(nums);
  }
}


// T.C => O(10 * n) = O(n)
// S.C => O(8 * n) = O(n)
