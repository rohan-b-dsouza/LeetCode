class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] rows = new int[n][2];
        int[][] cols = new int[m][2];
        for (int i = 0; i < n; i++) {
            for (int num : grid[i]) {
                rows[i][num]++;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cols[i][grid[j][i]]++;
            }
        }
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = rows[i][1] + cols[j][1] - rows[i][0] - cols[j][0];
            }
        }
        return ans;
    }
}