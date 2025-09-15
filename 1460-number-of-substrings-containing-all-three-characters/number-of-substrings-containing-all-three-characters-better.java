// Better (Sliding Window)

class Solution {
  public int numberOfSubstrings(String s) {
    int n = s.length();
    int ans = 0, l = 0;
    // Hash Array to store the frequency of characters
    int[] hash = new int[3];
    int r = 0;
    // Traverse till 'r' is within bounds
    while (r < n) {
      // Increment frequency of current character
      hash[s.charAt(r) - 'a']++;
      // If all 3 characters are present in current window then compute the maximum possible valid
      // substrings optimally using n - r
      while (hash[0] > 0 && hash[1] > 0 && hash[2] > 0) {
        ans += n - r;
        // Shrink the window by decrementing frequency of character at 'l' and incrementing 'l
        hash[s.charAt(l) - 'a']--;
        l++;
      }
      // Expand window to explore further possible substrings
      r++;
    }
    // Return the ans
    return ans;
  }
}

// T.C => O(2 * n) = O(n)
// S.C => O(3)
