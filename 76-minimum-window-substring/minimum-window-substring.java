class Solution {
  public String minWindow(String s, String t) {
    int m = s.length();
    int n = t.length();
    int[] hash = new int[256];
    for (int i = 0; i < n; i++) {
      hash[t.charAt(i)]++;
    }
    int start = -1;
    int end = -1;
    int minlen = Integer.MAX_VALUE;
    int l = 0;
    int cnt = 0;
    for (int r = 0; r < m; r++) {
      char ch = s.charAt(r);
      if (hash[ch] > 0) {
        cnt++;
      }
      hash[ch]--;
      while (cnt == n) {
        if (r - l + 1 < minlen) {
          minlen = r - l + 1;
          start = l;
          end = r;
        }
        hash[s.charAt(l)]++;
        if (hash[s.charAt(l)] > 0) {
          cnt--;
        }
        l++;
      }
    }
    return minlen == Integer.MAX_VALUE ? "" : s.substring(start, end + 1);
  }
}