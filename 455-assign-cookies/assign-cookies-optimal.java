// Optimal

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (s[j] >= g[i]) {
                i++;
            }
            j++;
        }
        return i;
    }
}

// T.C => O(n*log(n) + m*log(m) + O(min(n, m))
// S.C => O(1)
