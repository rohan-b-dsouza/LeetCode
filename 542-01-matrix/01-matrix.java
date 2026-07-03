class Pair {
    int row, col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Deque<Pair> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new Pair(i, j));
                }
            }
        }
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) ans[i][j] = -1;
            }
        }
        while (!queue.isEmpty()) {
            Pair peak = queue.poll();
            int r = peak.row; int c = peak.col;
            for (int i = c - 1; i <= c + 1; i++) {
                if (i < m && i >= 0 && ans[r][i] == -1) {
                    ans[r][i] = ans[r][c] + 1;
                    queue.offer(new Pair(r, i));
                }
            }
            for (int i = r - 1; i <= r + 1; i++) {
                if (i < n && i >= 0 && ans[i][c] == -1) {
                    ans[i][c] = ans[r][c] + 1;
                    queue.offer(new Pair(i, c));
                }
            }
        }
        return ans;
    }
}