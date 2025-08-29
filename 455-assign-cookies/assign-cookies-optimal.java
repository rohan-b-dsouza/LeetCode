// Optimal

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        // Sort both the arrays g and s
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        // Greedily assign cookies to students in such a way that you maximize the number of satisfied students without ever "wasting" a bigger cookie unnecessarily.
        while (i < n && j < m) {
            if (s[j] >= g[i]) {
                i++;
            }
            j++;
        }
        return i;
    }
}

// T.C => O(n*log(n) + m*log(m) + O(min(n, m)) = O(n*log(n) + m*log(m)
// S.C => O(1)
