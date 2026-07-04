class Solution {
    public void dfs(int r, int c, int n, int m, char[][] board) {
        board[r][c] = 'Z';
        for (int i = c - 1; i <= c + 1; i++) {
            if (i < m && i >= 0 && board[r][i] == 'O') {
                dfs(r, i, n, m, board);
            }
        }
        for (int i = r - 1; i <= r + 1; i++) {
            if (i < n && i >= 0 && board[i][c] == 'O') {
                dfs(i, c, n, m, board);
            }
        }
    }

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && (board[i][j] == 'O')) {
                    dfs(i, j, n, m, board);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'Z') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}