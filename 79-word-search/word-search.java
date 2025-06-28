class Solution {
  public boolean wordSearch(int index, int i, int j, char[][] board, String word, int n, int m) {
    // Base Case : Word is found
    if (index == word.length()) {
      return true;
    }
    // If cell is out of bounds or cell is visited (empty string) or cell doesn't match value at
    // word[index]
    if (i < 0 || i > n - 1 || j < 0 || j > m - 1 || board[i][j] != word.charAt(index)) {
      return false;
    }
    // Temporarily Mark current cell as visited
    char temp = board[i][j];
    board[i][j] = ' ';
    // check left, right, top, bottom cells

    boolean ans =
        wordSearch(index + 1, i, j - 1, board, word, n, m)
            || wordSearch(index + 1, i, j + 1, board, word, n, m)
            || wordSearch(index + 1, i - 1, j, board, word, n, m)
            || wordSearch(index + 1, i + 1, j, board, word, n, m);
    // Restore the original character in the cell
    board[i][j] = temp;
    return ans;
  }

  // Function to find first letter of word in the board
  public boolean findFirstLetter(char[][] board, String word) {
    int n = board.length; // row size
    int m = board[0].length; // column size
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == word.charAt(0)) { // if first letter found then start word search
          if (wordSearch(0, i, j, board, word, n, m)) { // If the word is found, return true
            return true;
          }
        }
      }
    }
    return false; // if word is not found return false
  }

  public boolean exist(char[][] board, String word) {
    return findFirstLetter(board, word);
  }
}
