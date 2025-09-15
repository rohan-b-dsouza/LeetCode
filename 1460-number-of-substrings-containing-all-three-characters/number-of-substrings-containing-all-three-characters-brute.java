// Brute

class Solution {
  public int numberOfSubstrings(String s) {
    int n = s.length();
    int ans = 0;
    for (int i = 0; i < n; i++) {
      // Hash Array to mark visited characters
      int[] hash = new int[3];
      // For each i, count the maximum possible valid substrings
      for (int j = i; j < n; j++) {
        // Mark current character as visited
        hash[s.charAt(j) - 'a'] = 1;
        // If all three characters i.e a, b, c are visited then count the number of valid substrings optimally i.e ans += n - j and break
        if (hash[0] + hash[1] + hash[2] == 3) {
            ans += n - j;
            break;
        }
      }
    }
    return ans;
  }
}


// T.C => O(n ^ 2)
// S.C => O(3)
