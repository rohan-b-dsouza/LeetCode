// Optimal

// Logic:- Traverse through the string, and keep adding the current character to the set. Check if the condition of residue is met, if so increment counter 'ans'

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

// T.C => O(n)
// S.C => O(26) = O(1)
