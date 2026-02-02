class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int n = s.length();
        if (n == 0) return 0;
        int ans = 1;
        while (r < n) {
            char curr = s.charAt(r);
            if (map.containsKey(curr) && map.get(curr) >= l) {
                l = map.get(curr) + 1;
            }
            map.put(curr, r);
            ans = Math.max(r - l + 1, ans);
            r++;
        }
        return ans;
    }
}