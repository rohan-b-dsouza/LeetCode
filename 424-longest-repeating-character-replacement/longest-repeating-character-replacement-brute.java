// Brute

class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            // Hash array to store the frequency of Uppercase Character
            int[] hash = new int[26];
            // Stores maximum frequency encountered so far
            int maxFreq = 0;
            // Generate the longest valid substring possible
            for (int j = i; j < n; j++) {
                // Increment frequency of current character
                hash[s.charAt(j) - 'A']++;
                // Update maxFreq
                maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']);
                // Compute no. of replacements reqd
                int replacements = (j - i + 1) - maxFreq;
                // If replacements reqd are greater than k, then break
                if (replacements > k)
                    break;
                // Update maxlen
                maxlen = Math.max(maxlen, j - i + 1);
            }
        }
        // Return maxlen
        return maxlen;
    }
}

// T.C => O(n ^ 2)
// S.C => O(26)
