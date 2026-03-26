class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String s = new String(charArr);
            if (!map.containsKey(s)) {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                ans.add(temp);
                map.put(s, idx);
                idx++;
            }
            else ans.get(map.get(s)).add(strs[i]);
        }
        return ans;
    }
}