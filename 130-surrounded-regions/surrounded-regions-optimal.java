// Optimal

class Pair {
  int row;
  int col;
  Pair(int row, int col) {
    this.row = row;
    this.col = col;
  }
}
// Logic:- Traverse through the 4 boundaries of the matrix and whenever 'O' occurs, mark all its connected Os as Z. Now, traverse again through the matrix marking all 'Z's as Os. This works because all 
// connected groups forming from boundary Os will be always unchanged as they are not considered as 'surrounded regions'


class Solution {
  public void bfs(int i, int j, char[][] board, int n, int m) {
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    Deque<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(i, j));
    while(!queue.isEmpty()) {
      Pair pair = queue.poll();
      int row = pair.row;
      int col = pair.col;
      for (int[] direction : directions) {
        int r = direction[0] + row;
        int c = direction[1] + col;
        if (r >= 0 && r < n && c >= 0 && c < m && board[r][c] == 'O' && board[r][c] != 'Z') {
          board[r][c] = 'Z';
          queue.offer(new Pair(r, c));
        }
      }
    }
  }
    public void solve(char[][] board) {
    int n = board.length;
    int m = board[0].length;
    for (int i = 0; i < m; i++) {
      if (board[0][i] == 'O') {
        board[0][i] = 'Z';
        bfs(0, i, board, n, m);
      }
    }
    for (int i = 1; i < n; i++) {
      if (board[i][0] == 'O') {
        board[i][0] = 'Z';
        bfs(i, 0, board, n, m);
      }
    }
    for (int i = 1; i < m; i++) {
      if (board[n - 1][i] == 'O') {
        board[n - 1][i] = 'Z';
        bfs(n - 1, i, board, n, m);
      }
    }
    for (int i = 1; i < n - 1; i++) {
      if (board[i][m - 1] == 'O') {
        board[i][m - 1] = 'Z';
        bfs(i, m - 1, board, n, m);
      } 
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == 'Z') {
          board[i][j] = 'O';
        }
        else board[i][j] = 'X';
      }
    }
    } 
}
