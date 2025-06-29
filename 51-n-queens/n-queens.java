class Solution {
    public boolean canPlaceQueen(int row, int col, char[][] board, int n) {
        int r = row; int c = col;
        // check if queen is present in any cell vertically above current cell
        while (r >= 0) { 
            if (board[r][c] == 'Q') {
                return false;
            }
            r--;
        }
        r = row; c = col;
        // check if queen is present in any cell in the left diagonal of current cell
        while (r >= 0 && c >= 0) { 
            if (board[r][c] == 'Q') {
                return false;
            }
            r--; c--;
        }
        // check if queen is present in any cell in the right diagonal of current cell
        r = row; c = col; 
        while (r >= 0 && c < n) {
            if (board[r][c] == 'Q') {
                return false;
            }
            r--; c++;
        }
    return true;
    }
    // function to copy char[][] board to a List<String> as we need to return List<List<String>>
    public List<String> construct (int n, char[][] board) {
        List<String> listboard = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listboard.add(new String(board[i]));
        }
        return listboard;
    }
    public void arrangeNQueens(int row, int n, List<List<String>> ans, char[][] board) {
        // Base Case : Add arrangement to the answer
        if (row == n) {
            ans.add(construct(n, board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (canPlaceQueen(row, col, board, n)) { // check if queen can be placed in that cell
                board[row][col] = 'Q'; // if yes then add Queen to that cell
                arrangeNQueens(row + 1, n, ans, board); // recursively place Queens on further rows
                board[row][col] = '.'; // backtrack to explore other paths (cols) by removing the earlier Queen Placements
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        String str = ".".repeat(n); // fills str with "." (O(n))
        for (int i = 0; i < n; i++) { // fills board with "."
            board[i] = str.toCharArray();
        }
        arrangeNQueens(0, n, ans, board);
        return ans;
    }
}