import java.util.*;


class Pair {
  int row;
  int col;
  Pair(int r, int c) {
    row = r;
    col = c;
  }
}
class Solution {
  public int bfs (int row, int col, int[][] grid, int n, int m, int[][] visited) {
    Deque<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(row, col));
    visited[row][col] = 1;
    boolean flag = true;
    int cnt = 0;
    while(!queue.isEmpty()) {
      Pair pair = queue.poll();
      int r = pair.row;
      int c = pair.col;
      if (r - 1 < 0 || r + 1 >= n || c - 1 < 0 || c + 1 >= m) {
        flag = false;
      }
      if (r - 1 >= 0 && grid[r - 1][c] == 1 && visited[r - 1][c] != 1) {
        queue.offer(new Pair(r - 1, c));
        visited[r - 1][c] = 1;
      }
      if (r + 1 < n && grid[r + 1][c] == 1 && visited[r + 1][c] != 1) {
        queue.offer(new Pair(r + 1, c));
        visited[r + 1][c] = 1;
      }
      if (c - 1 >= 0 && grid[r][c - 1] == 1 && visited[r][c - 1] != 1) {
        queue.offer(new Pair(r, c - 1));
        visited[r][c - 1] = 1;
      }
      if (c + 1 < m && grid[r][c + 1] == 1 && visited[r][c + 1] != 1) {
        queue.offer(new Pair(r, c + 1));
        visited[r][c + 1] = 1;
      }
      cnt++;
    }
    return flag == true ? cnt : 0;
  }
  public int numEnclaves(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int cnt = 0;
    int[][] visited = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1 && visited[i][j] != 1) {
            cnt += bfs(i, j, grid, n, m, visited);
        }
      }
    }
    return cnt;
  }
}
