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
