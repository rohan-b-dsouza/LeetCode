class Pair {
  int row;
  int col;

  Pair(int r, int c) {
    row = r;
    col = c;
  }
}


class Solution {
  public void bfs(int row, int col, char[][] grid, int[][] visited, int n, int m) {
    Deque<Pair> queue = new ArrayDeque<>();
    visited[row][col] = 1;
    queue.offer(new Pair(row, col));
    while (!queue.isEmpty()) {
      Pair pair = queue.poll();
      int currRow = pair.row;
      int currCol = pair.col;
      if (currRow - 1 >= 0 && visited[currRow - 1][currCol] != 1 && grid[currRow - 1][currCol] == '1') {
        queue.offer(new Pair(currRow - 1, currCol));
        visited[currRow - 1][currCol] = 1;
      }
      if (currRow + 1 < n && visited[currRow + 1][currCol] != 1 && grid[currRow + 1][currCol] == '1') {
        queue.offer(new Pair(currRow + 1, currCol));
        visited[currRow + 1][currCol] = 1;
      }
      if (currCol - 1 >= 0 && visited[currRow][currCol - 1] != 1 && grid[currRow][currCol - 1] == '1') {
        queue.offer(new Pair(currRow, currCol - 1));
        visited[currRow][currCol - 1] = 1;
      }
      if (currCol + 1 < m && visited[currRow][currCol + 1] != 1 && grid[currRow][currCol + 1] == '1') {
        queue.offer(new Pair(currRow, currCol + 1));
        visited[currRow][currCol + 1] = 1;
      }
    }
  }

  public int numIslands(char[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int[][] visited = new int[n][m];
    int island = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == '1' && visited[i][j] != 1) {
          visited[i][j] = 1;
          bfs(i, j, grid, visited, n, m);
          island++;
        }
      }
    }
    return island;
  }
}
