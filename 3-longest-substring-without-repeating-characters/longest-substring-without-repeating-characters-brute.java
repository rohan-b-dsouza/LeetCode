// Brute

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            // Array to mark visited characters 
            int[] hash = new int[256];
            int len = 0;
            // For each i, find the longest consecutive sequence of non - repeating characters
            for (int j = i; j < n; j++) {
                // If current character has not occured earlier, mark it visited and increment len
                if (hash[s.charAt(j)] == 0) {
                    hash[s.charAt(j)]++;
                    len++;
                }
                // If current character is visited then break 
                else {
                    break;
                }
                // At each step update maxlen
                maxlen = Math.max(maxlen, len);
            }
        }
        return maxlen;
    }
}

// T.C => O(n ^ 2)
// S.C => O(256)
