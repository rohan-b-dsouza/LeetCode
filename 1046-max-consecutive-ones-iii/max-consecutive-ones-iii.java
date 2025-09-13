// Brute 

class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        // Initialize maxlen to 0
        int maxlen = 0;
        // Generate all possible substrings using 2 nested loops
        for (int i = 0; i < n; i++) {
            // Initialize zeroes to 0
            int zeroes = 0;
            // Find the longest possible substring with atmost k 0s
            for (int j = i; j < n; j++) {
                // If current element is a zero, increment zeroes
                if (nums[j] == 0) zeroes++;
                // If zeroes exceed k break
                if (zeroes > k) break;
                // Else update maxlen
                else {
                    maxlen = Math.max(j - i + 1, maxlen);
                }
            }
        }
        // Return maxlen
        return maxlen;
    }
}