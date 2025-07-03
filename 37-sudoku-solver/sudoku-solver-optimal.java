// Optimal

class Solution {
  // Function to check whether the current digit can be placed in the empty cell or not
  public boolean canPlaceDigit(char digit, int row, int col, char[][] board) {
    for (int j = 0; j < 9; j++) { // check if digit already exists in current empty cells row
      if (board[row][j] == digit) return false;
    }
    for (int i = 0; i < 9; i++) { // check if digit already exists in current empty cells col
      if (board[i][col] == digit) return false;
    }
    // check if digit already exists in current empty cells subgrid
    int startRow = (row / 3) * 3; // gets subgrids starting row
    int startCol = (col / 3) * 3; // gets subgrids starting col
    // Iterate through the subgrid and check if digit exists already
    for (int i = startRow; i < startRow + 3; i++) {
      for (int j = startCol; j < startCol + 3; j++) {
        if (board[i][j] == digit) return false;
      }
    }
    return true;
  }

  public boolean solve(char[][] board) {
    // traverse the board
    for (int row = 0; row < 9; row++) {
      for (int col = 0; col < 9; col++) {
        if (board[row][col] == '.') { // if empty cell is found
          for (char digit = '1';
              digit <= '9';
              digit++) { // try placing digits from 1 to 9 (exploring all paths)
            if (canPlaceDigit(digit, row, col, board)) { // if rules to place a digit are met place the digit
              board[row][col] = digit;
              // Base Case : if entire board is filled then solve(board) returns true, hence return
              // true and end the recursion
              if (solve(board)) {
                return true;
                // if solve(board) returns false, it means all empty cells weren't filled, hence
                // backtrack by again emptying the cell and try filling other digits (i.e explore
                // other paths)
              } else {
                board[row][col] = '.';
              }
            }
          }
          return false; // if an empty cell could not be filled return false
        }
      }
    }
    return true; // if all empty cells were filled successfully return true
  }

  public void solveSudoku(char[][] board) {
    solve(board); // calling function which solves the sudoku board
  }
}

// T.C => O(9 ^ E) as for every empty cell we can try about 9 digits ---(the use of nested loops (total 9 * 9 = 81 iterations) is negligible as recursion T.C itself is exponential)
// S.C => O(E) is the recursion stack space
