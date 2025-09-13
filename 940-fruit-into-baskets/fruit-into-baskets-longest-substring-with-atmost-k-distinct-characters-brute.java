// Brute (Same as the problem Longest Substring With At Most K Distinct Characters (T.C = O(n ^ 2), S.C = O(k))) (Just replace 2 with k in code)

class Solution {
    public int totalFruits(int[] fruits) {
        int n = fruits.length;
        int maxlen = 0;
      // Generate all possible valid subarrays 
        for (int i = 0; i < n; i++) {
          // Set to store occurence of a kind of fruit
            HashSet<Integer> st = new HashSet<>();
          // Find the max possible valid subarray from current i 
            for (int j = i; j < n; j++) {
              // Add current fruit to set
                st.add(fruits[j]);
              // If fruit types exceed 2 break
                if (st.size() > 2) break;
              // Update maxlen
                maxlen = Math.max(j - i + 1, maxlen);
            }
        }
      // Return maxlen
        return maxlen;
    }
}

// T.C => O(n ^ 2)
// S.C => O(1)
