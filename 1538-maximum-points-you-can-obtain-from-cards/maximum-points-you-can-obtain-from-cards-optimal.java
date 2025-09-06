// Optimal (Sliding window)

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        // Calculate sum of first k elements from left
        for (int i = 0; i < k; i++) {
          sum += cardPoints[i];
        }
        // Initialize max with sum
        int max = sum;
        // Initialize a right pointer
        int right = n - 1;
        // Start iterating from k to 0
        for (int i = k - 1; i >= 0; i--) {
          // Remove one element (Shrink window by 1 on left)
          sum -= cardPoints[i];
          // Take one element from right (Expand window by 1 from right)
          sum += cardPoints[right--];
          // If sum is greater than max, update max with sum 
          if (sum > max) max = sum;
        }
        // Return max score
        return max;
    }
}

// T.C => O(2 * k) = O(k)
// S.C => O(1)
