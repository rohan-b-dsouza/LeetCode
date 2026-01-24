// Optimal 

// Logic:- Logic used here is similar to that in largest histogram, just made changes to fit for this problem. Instead of precomputing nse and pse, we compute it on the fly.

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long sum = 0;
        int MOD = 1000000007;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
          while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
            int idx = stack.pop();
            int nse = i;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            int left = idx - pse;
            int right = nse - idx;
            sum = (sum + (left * 1L * right * arr[idx]) % MOD) % MOD;
          }
          stack.push(i);
        }
        while(!stack.isEmpty()) {
          int idx = stack.pop();
          int nse = n;
          int pse = stack.isEmpty() ? -1 : stack.peek();
          int left = idx - pse;
          int right = nse - idx;
          sum = (sum + (left * 1L * right * arr[idx]) % MOD) % MOD;
        }
        return (int) sum;
    }
}

// T.C => O(n)
// S.C => O(n)
