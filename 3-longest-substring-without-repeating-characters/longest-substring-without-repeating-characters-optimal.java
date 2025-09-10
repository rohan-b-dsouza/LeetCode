// Optimal

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        // Hash map that stores {character, index} of last occurence 
        int[] hash = new int[256];
        // Initialise it with -1
        Arrays.fill(hash, -1);
        int l = 0;
        int r = 0;
        int maxlen = 0;
        while (r < n) {
          /* If current character s[r]  
            is already in the substring*/
          if (hash[s.charAt(r)] >= l) {
            /* Move left pointer to the right
                of the last occurrence of s[r]*/
            l = hash[s.charAt(r)] + 1;
          }
          // Update maxlen
          maxlen = Math.max(maxlen, r - l + 1);
          // Store index of occurence of current character
          hash[s.charAt(r)] = r;
          // Move r to next position
          r++;
        }
        return maxlen;
    }
}

// T.C => O(n)
// S.C => O(1)
