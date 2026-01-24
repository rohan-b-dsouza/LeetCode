// Optimal

// Logic:- First build a prefix sum array. Now, for each element apply monotonic stack + contribution technique.
// In each step, keep the current element as minimum and get the subarray left and right bounds ensuring current element is minimum. 
// Compute the min - product sum, updating the max value seen so far.

class Solution {
  public int maxSumMinProduct(int[] nums) {
    int n = nums.length;
    int MOD = 1000000007;
    long[] prefixSum = new long[n];
    long sum = 0;
    long ans = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      prefixSum[i] = sum;
    }
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
        int idx = stack.pop();
        int nse = i;
        int pse = stack.isEmpty() ? -1 : stack.peek();
        int left = pse + 1;
        int right = nse - 1;
        if (left == 0)
          ans = Math.max(nums[idx] * 1L * prefixSum[right], ans);
        else
          ans = Math.max(nums[idx] * 1L * (prefixSum[right] - prefixSum[left - 1]), ans);
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      int idx = stack.pop();
      int nse = n;
      int pse = stack.isEmpty() ? -1 : stack.peek();
      int left = pse + 1;
      int right = nse - 1;
      if (left == 0)
        ans = Math.max(nums[idx] * 1L * prefixSum[right], ans);
      else
        ans = Math.max(nums[idx] * 1L * (prefixSum[right] - prefixSum[left - 1]), ans);
    }
    return (int) (ans % MOD);
  }
}

// T.C => O(2 * n) = O(n)
// S.C => O(2 * n) = O(n)
