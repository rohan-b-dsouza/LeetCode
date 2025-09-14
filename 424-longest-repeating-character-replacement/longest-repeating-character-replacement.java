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
          // If no. of replacements reqd is greater than k
          while (((r - l + 1) - maxFreq) > k) {
            // Decrement freq of Character at 'l'
            hash[s.charAt(l) - 'A']--;
            // Shrink window using 'l' pointer
            l++;
            // Update the maxFreq as freq of Character at 'l' was decreased
            for (int i = 0; i < 26; i++) {
              maxFreq = Math.max(maxFreq, hash[i]);
            }
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

// class Solution {
//     public int characterReplacement(String s, int k) {
//         int n = s.length();
//         int maxlen = 0;
//         for (int i = 0; i < n; i++) {
//             int[] hash = new int[26];
//             int maxFreq = 0;
//             for (int j = i; j < n; j++) {
//                 hash[s.charAt(j) - 'A']++;
//                 maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']); 
//                 int replacements = (j - i + 1) - maxFreq;
//                 if (replacements > k) break;
//                 maxlen = Math.max(maxlen, j - i + 1);
//             }
//         }
//         return maxlen;
//     }
// }