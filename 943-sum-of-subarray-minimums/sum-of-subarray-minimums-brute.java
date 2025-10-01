// Brute

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        final int MOD = 1000000007;
        int sum = 0;
        // Generate all subarrays
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
          // Track the running minimum and keep adding it to sum
            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                sum = (sum + min) % MOD;
            }
        }
      // Return the sum
        return sum;
    }
}

// T.C => O(n ^ 2)
// S.C => O(1)
