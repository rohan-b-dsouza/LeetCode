// Brute

class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int maxlen = Integer.MAX_VALUE;  
      int startIdx = -1;
        int endIdx = -1;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
          // Hash array to store frequencies of characters in 't' string
            int[] hash = new int[256];
            for (int k = 0; k < m; k++) {
            hash[t.charAt(k)]++;
        }
          // For each i, generate the minimum possible valid substring
            for (int j = i; j < n; j++) {
              // If current character is present in the string 't' then increment count of reqd characters and decrement its frequency from the hash array
                if (hash[s.charAt(j)] > 0) {
                    cnt++;
                    hash[s.charAt(j)]--;
                }
              // If the counter becomes equal to m then store the starting and ending index of this substring if its size is smaller than maxlen and break
                if (cnt == m) {
                    if (j - i + 1 < maxlen) {
                        maxlen = j - i + 1;
                        startIdx = i;
                        endIdx = j;
                    }
                    break;
                }
            }
        }
      // Return the substring
        return (startIdx == -1) ? "" : s.substring(startIdx, endIdx + 1);
    }
}

// T.C => O(n ^ 2)
// S.C => O(256)
