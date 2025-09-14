
// Better (Sliding Window)

class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0;
        int r = 0;
        // maxFreq stores the maximum frequency discovered so far
        int maxFreq = 0;
        int maxlen = 0;
        // Hash array to store frequency of each Uppercase Character
        int[] hash = new int[26];
        // Traverse till r is within bounds
        while (r < n) {
          // Increment freq of current character
          hash[s.charAt(r) - 'A']++;
          // Update maxFreq
          maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);
          // If no. of replacements reqd is greater than k, decrement freq of character at 'l' by 1, and try to find larger valid substring in next iteration
          if (((r - l + 1) - maxFreq) > k) {
            // Decrement freq of Character at 'l'
            hash[s.charAt(l) - 'A']--;
            // Shrink window using 'l' pointer
            l++;
            // Unlike the 'Better' Solution, don't update maxFreq as its not reqd because we require a larger substring than current maxlen encountered so far so we require larger maxFreq too. Decreasing maxFreq won't help, as keeping it as it is will also not bring about any anomalies (DRY RUN ON TESTCASE :- Input : s = "BAABAABBBAAA" , k = 2 TO UNDERSTAND BETTER)
          }
          // Update maxlen
          maxlen = Math.max(maxlen, r - l + 1); 
          // Expand the window using 'r' pointer
          r++;
        }
        // Return maxlen
        return maxlen;
    }
}

// T.C => O(n + (n * 26)) = O(n)
// S.C => O(26)
