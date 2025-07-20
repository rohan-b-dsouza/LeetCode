class Solution {
    public List<String> partitionString(String s) {
        StringBuilder str = new StringBuilder();
        HashSet<String> hs = new HashSet<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            str.append(s.charAt(i));
            if (!hs.contains(str.toString())) {
                hs.add(str.toString());
                ans.add(str.toString());
                str.setLength(0);
            }
        }
        return ans;
    }
}