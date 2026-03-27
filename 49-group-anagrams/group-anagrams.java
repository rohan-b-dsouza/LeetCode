class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        int idx = 0;
        List<List<String>> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
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
            if (!map.containsKey(freqStr)) {
                map.put(freqStr, idx);
                List<String> temp = new ArrayList<>();
                temp.add(s);
                ans.add(temp);
                idx++;
            }
            else ans.get(map.get(freqStr)).add(s);
        }
        return ans;
    }
}