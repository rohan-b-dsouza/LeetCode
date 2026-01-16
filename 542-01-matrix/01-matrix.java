class Tuple {
    int row;
    int col;
    int dist;
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
    int[][] directions = { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };
    int[][] visited = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (mat[i][j] == 0) {
          queue.offer(new Tuple(i, j, 0));
        }
      }
    }
    while (!queue.isEmpty()) {
      Tuple tuple = queue.poll();
      int row = tuple.row;
      int col = tuple.col;
      int dist = tuple.dist;
      for (int[] direction : directions) {
        int nrow = direction[0] + row;
        int ncol = direction[1] + col;
        if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && mat[nrow][ncol] != 0 && visited[nrow][ncol] == 0) {
          visited[nrow][ncol] = dist + 1;
          queue.offer(new Tuple(nrow, ncol, dist + 1));
        }
      }
    }
    return visited;
  }
}