// Optimal

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

// T.C => O(n^2) when all characters are unique (worst case) --------{since toString() function takes O(k) time to convert to string where k is size of stringbuilder}
// S.C => O(n)
