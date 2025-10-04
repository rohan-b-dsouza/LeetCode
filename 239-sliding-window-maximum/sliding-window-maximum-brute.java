// Brute

class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        // Declare the 'ans' array of size n - k + 1, as it will be storing n - k + 1 maximums
        int[] ans = new int[n - k + 1];
        // Iterate upto n - k + 1
        for (int i = 0; i < n - k + 1; i++) {
            // Initialize max 
            int max = Integer.MIN_VALUE;
            // For each window of size k starting from i, find the max element
            for (int j = i; j < i + k; j++) {
                max = Math.max(arr[j], max);
            }
          // Store it to the 'ans' array
            ans[i] = max;
        }
        // Return the ans
        return ans;
    }
}

// T.C => O((n - k + 1) * k) = O(n)
// S.C => O(n - k + 1) = O(n)
