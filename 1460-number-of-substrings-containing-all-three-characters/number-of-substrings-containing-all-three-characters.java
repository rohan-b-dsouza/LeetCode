// Better (Sliding Window)

class Solution {
  public int numberOfSubstrings(String s) {
    int n = s.length();
    int ans = 0;
    int l = 0;
    int r = 0;
    // Hash array to store frequency of characters
    int[] hash = new int[3];
    int cnt = 0; 
    // Traverse till r is within bounds
    while (r < n) {
      // If current character is appearing first time increment counter
      if (hash[s.charAt(r) - 'a'] == 0) {
        cnt++;
      }
      // Also increment frequency of the character in the map
      hash[s.charAt(r) - 'a']++;
      // If all 3 elements have arrived
      while (cnt == 3) {
        // Compute the no. of valid substrings
        ans += n - r;
        // Decrement frequency of character at 'l'
        hash[s.charAt(l) - 'a']--;
        // If the frequency of this character becomes zero, it means we are back to invalid state hence decrement counter to end this inner loop and explore characters on right of 'r' to go back into valid state
        if (hash[s.charAt(l) - 'a'] == 0) {
          cnt--;
        }
        // Shrink window using left pointer 'l'
        l++;
      }
      // Expand the window using right pointer
      r++;
    }
    return ans;
  }
}


// class Solution {
//   public int numberOfSubstrings(String s) {
//     int n = s.length();
//     int ans = 0;
//     for (int i = 0; i < n; i++) {
//       int[] hash = new int[3];
//       int cnt = 0;
//       for (int j = i; j < n; j++) {
//         if (hash[s.charAt(j) - 'a'] != 1) {
//           cnt++;
//         }
//         hash[s.charAt(j) - 'a'] = 1;
//         if (cnt == 3) {
//             ans += n - j;
//             break;
//         }
//       }
//     }
//     return ans;
//   }
// }
