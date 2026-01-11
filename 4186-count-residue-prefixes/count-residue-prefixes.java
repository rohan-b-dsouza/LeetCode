class Solution {
    public boolean isResidue(String s) {
        Set<Character> st = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            st.add(s.charAt(i));
        }
        if (st.size() == s.length() % 3) return true;
        return false;
    }
    public int residuePrefixes(String s) { 
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isResidue(s.substring(0, i + 1))) {
                ans++;
            }
        }
        return ans;
    }
}