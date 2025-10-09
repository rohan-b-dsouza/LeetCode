// Optimal 
// VVIMP : Refer the GFG Problem 'The Celebrity Problem' in which the input is given in a different way but it changes the solutions significantly, so its very important to solve that problem too.

class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1) return 1; // Special case: single person

        int[] trustScore = new int[n + 1]; // +1 to use 1-based indexing

        for (int[] t : trust) {
            int a = t[0], b = t[1];
            trustScore[a]--; // person a trusts someone → lose 1 point
            trustScore[b]++; // person b is trusted → gain 1 point
        }

        for (int i = 1; i <= n; i++) {
            if (trustScore[i] == n - 1) {
                return i; // judge found
            }
        }
        return -1; // no judge
    }
}

// T.C => O(n) + O(n) = O(2 * n)
// S.C => O(n)
