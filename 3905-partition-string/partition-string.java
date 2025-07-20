class Solution {
    public List<String> partitionString(String s) {
        String str = "";
        HashSet<String> hs = new HashSet<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            str += s.charAt(i);
            if (!hs.contains(str)) {
                hs.add(str);
                ans.add(str);
                str = "";
            }
        }
        return ans;
    }
}