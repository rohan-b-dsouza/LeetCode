class Tuple {
    int row, col, dist;
    Tuple(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Deque<Tuple> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new Tuple(i, j, 0));
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
            Tuple peak = queue.poll();
            int r = peak.row; int c = peak.col; int dist = peak.dist;
            for (int i = c - 1; i <= c + 1; i++) {
                if (i < m && i >= 0 && mat[r][i] == 1 && ans[r][i] == -1) {
                    ans[r][i] = dist + 1;
                    queue.offer(new Tuple(r, i, dist + 1));
                }
            }
            for (int i = r - 1; i <= r + 1; i++) {
                if (i < n && i >= 0 && mat[i][c] == 1 && ans[i][c] == -1) {
                    ans[i][c] = dist + 1;
                    queue.offer(new Tuple(i, c, dist + 1));
                }
            }
        }
        return ans;
    }
}