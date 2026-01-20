class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                // move left to one past last occurrence of ch, but never move left backwards
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right);                      // update last index of ch
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}