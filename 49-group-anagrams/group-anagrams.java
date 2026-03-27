class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        int idx = 0;
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = strs[i];
            int[] freq = new int[26];
            for (int j = 0; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                sb.append(freq[j]).append(',');
            }
            String freqStr = sb.toString();
            map.computeIfAbsent(freqStr, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}