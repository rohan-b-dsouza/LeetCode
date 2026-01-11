class Solution {
    public int residuePrefixes(String s) {
        Set<Character> st = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            st.add(s.charAt(i));
            if ((i + 1) % 3 == st.size()) ans++;
        }
        return ans;
    }
}