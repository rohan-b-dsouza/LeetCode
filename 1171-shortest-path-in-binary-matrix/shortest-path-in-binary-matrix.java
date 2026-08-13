class Tuple {
    int row, col, weight;
    Tuple(int row, int col, int weight) {
        this.row = row;
        this.col = col;
        this.weight = weight;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Deque<Tuple> queue = new ArrayDeque<>();
        queue.offer(new Tuple(0, 0, 1));
        if (grid[0][0] != 0) return -1;
        grid[0][0] = -1;
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            int r = tuple.row;
            int c = tuple.col;
            int wt = tuple.weight;
            if (r == n - 1 && c == m - 1)
                return wt;
            for (int i = r - 1; i <= r + 1; i++) {
                if (i < 0 || i >= n)
                    continue;
                for (int j = c - 1; j <= c + 1; j++) {
                    if (j >= 0 && j < m && grid[i][j] == 0) {
                        queue.offer(new Tuple(i, j, wt + 1));
                        grid[i][j] = -1;
                    }
                }
            }
        }
        return -1;

    }
}