class Tuple {
    int row, col, minute;
    Tuple(int row, int col, int minute) {
        this.row = row;
        this.col = col;
        this.minute = minute;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Deque<Tuple> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Tuple(i, j, 0));
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            Tuple peak = queue.poll();
            int r = peak.row; int c = peak.col; int minute = peak.minute;
            ans = Math.max(ans, minute);
            System.out.println(minute);
            for (int i = c - 1; i <= c + 1; i++) {
                if (i < m && i >= 0 && grid[r][i] == 1) {
                    grid[r][i] = 2;
                    queue.offer(new Tuple(r, i, minute + 1));
                }
            }
            for (int i = r - 1; i <= r + 1; i++) {
                if (i < n && i >= 0 && grid[i][c] == 1) {
                    grid[i][c] = 2;
                    queue.offer(new Tuple(i, c, minute + 1));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return ans;
    }
}