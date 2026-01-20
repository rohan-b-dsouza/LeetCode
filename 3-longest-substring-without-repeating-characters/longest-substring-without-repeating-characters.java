class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int cnt = 0;
        int maxcnt = 1;
        int i = 0;
        int lastIdx = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (i < n) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch) || (map.containsKey(ch) && (map.get(ch) < lastIdx))) {
                cnt++;
            }
            else {
                cnt = (i - map.get(ch));
                lastIdx = map.get(ch) + 1;
            }
            maxcnt = Math.max(maxcnt, cnt);
            map.put(ch, i);
            i++;
        }
        return maxcnt;
    }
}