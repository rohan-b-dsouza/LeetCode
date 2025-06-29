// Optimal

class Solution {
    // function to copy char[][] board to a List<String> as we need to return List<List<String>>
    public List<String> construct (int n, char[][] board) {
        List<String> listboard = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listboard.add(new String(board[i]));
        }
        return listboard;
    }

    public void arrangeNQueens(int row, int n, List<List<String>> ans, char[][] board, int[] visitedCol, int[] lowerDiag,
            int[] upperDiag) {
        // Base Case : Add arrangement to the answer
        if (row == n) {
            ans.add(construct(n, board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (visitedCol[col] != 1 && lowerDiag[row + col] != 1 && upperDiag[(row - col) + (n - 1)] != 1) { // check if queen can be placed in that cell
                visitedCol[col] = 1; // mark corresponding column as visited
                lowerDiag[row + col] = 1; // mark corresponding lower diagonal as visited
                upperDiag[(row - col) + (n - 1)] = 1; // mark corresponding upper diagonal as visited
                board[row][col] = 'Q'; // if yes then add Queen to that cell
                arrangeNQueens(row + 1, n, ans, board, visitedCol, lowerDiag, upperDiag); // recursively place Queens on further rows
                // backtrack to explore other paths (cols) by removing the earlier Queen Placements and visited col and diagonal marks
                board[row][col] = '.'; 
                visitedCol[col] = 0; 
                lowerDiag[row + col] = 0; 
                upperDiag[(row - col) + (n - 1)] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        int[] visitedCol = new int[n];
        int[] lowerDiag = new int[2 * n - 1];
        int[] upperDiag = new int[2 * n - 1];
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        String str = ".".repeat(n); // fills str with "." (O(n))
        for (int i = 0; i < n; i++) { // fills board with "."
            board[i] = str.toCharArray();
        }
        arrangeNQueens(0, n, ans, board, visitedCol, lowerDiag, upperDiag);
        return ans;
    }
}

// T.C => O(n!) approx.
// S.C => O(n) recursive stack space + O(n^2) for board array + O(n) for visited array and upper and lower diag array each + O(k * n^2) for result storage where k is no. of solutions
