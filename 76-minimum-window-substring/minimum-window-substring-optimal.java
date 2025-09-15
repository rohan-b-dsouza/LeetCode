// Optimal (Sliding Window)

class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(); // Size of string 's'
        int m = t.length(); // Size of string 't'
        int l = 0; int r = 0; // Assign left and right pointers to 0 initially
        int start = -1; // Initialize two variables start and end to store starting and ending indices of substring
        int end = -1;
        int cnt = 0; 
        int minlen = Integer.MAX_VALUE;
        // Hash array to count frequencies of characters in string 't'
        int[] hash = new int[256];
        // Store frequencies of characters in string 't' in hash array
        for (int i = 0; i < m; i++) {
            hash[t.charAt(i)]++;
        }
        // Traverse till r is 'within' bounds
        while (r < n) {
            // If current character is a present in string 't' then increment count of seen characters
            if (hash[s.charAt(r)] > 0) {
                cnt++;
            }
            // Decrement frequency of this character from hash array
            hash[s.charAt(r)]--;
            // If all characters from string t are seen in string s then start shrinking the window from left to explore smaller valid substrings
            while (cnt == m) {
                // If current length is smaller than minlen update minlen and store indices of this substring
                if (r - l + 1 < minlen) {
                    minlen = r - l + 1;
                    start = l;
                    end = r;
                }
                // Re increment frequency of character at 'l' pointer i.e put it back into hash array
                hash[s.charAt(l)]++;
                // If frequency of this character becomes 1 it means the character is no longer present in current substring, hence decrement counter as now the substring is invalid and we need to expand window further to get valid substring
                if (hash[s.charAt(l)] > 0) {
                    cnt--;
                }
                // Increment left pointer 'l' to shrink the window in each iteration of this inner while loop
                l++;
            }
            // Expand the window using 'r' pointer
            r++;
        }
        // Return the substring
        return (start == -1) ? "" : s.substring(start, end + 1);
    }
}

// T.C => O(2 * n) = O(n)
// S.C => O(256)
