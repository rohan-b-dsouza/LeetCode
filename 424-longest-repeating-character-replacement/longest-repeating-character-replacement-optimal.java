// Optimal Solution (Sliding Window)

class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0, r = 0;
        int maxFreq = 0;       // stores the maximum frequency of a single character in the current window
        int maxlen = 0;        // stores the length of the longest valid substring
        int[] hash = new int[26]; // frequency array for uppercase characters

        while (r < n) {
            // Increment frequency of the current character
            hash[s.charAt(r) - 'A']++;
            // Update the maximum frequency seen so far in the window
            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);

            // If the number of replacements needed exceeds k, shrink the window
            if ((r - l + 1 - maxFreq) > k) {
                // Decrement frequency of the character at the left pointer
                hash[s.charAt(l) - 'A']--;
                // Move left pointer to shrink the window
                l++;
                // Note: We do NOT update maxFreq here because it won't affect correctness.
                // maxFreq represents the max frequency seen so far, which is enough for this logic.
                // 
                // DRYRUN on TESTCASE - Input : s = "BAABAABBBAAA" , k = 2 to understand better.
            }

            // Update the maximum length of valid substring
            maxlen = Math.max(maxlen, r - l + 1);

            // Expand the window by moving the right pointer
            r++;
        }
        return maxlen;
    }
}

// T.C => O(n)
// S.C => O(1)
