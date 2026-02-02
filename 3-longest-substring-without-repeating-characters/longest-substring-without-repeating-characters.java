class Solution {
    public int lengthOfLongestSubstring(String s) {
         // code here
        int n = s.length();
        if (n == 0) return 0;
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        int l = 0;
        int ans = 0;
        for (int r = 0; r < n; r++) {
            char ch = s.charAt(r);
            l = Math.max(l, hash[ch] + 1);
            hash[ch] = r;
            ans = Math.max(r - l + 1, ans);
        }
        return ans;
    }
}