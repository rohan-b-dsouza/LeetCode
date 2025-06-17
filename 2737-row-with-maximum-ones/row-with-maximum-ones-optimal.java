// Optimal (Use only when array is already in sorted order) 
// Top - right traversal technique

class Solution {
    public int rowWithMax1s(int[][] mat) {
       int n = mat.length;
       int m = mat[0].length;
       int row = 0;
       int col = m - 1;
       int maxOneRowIdx = -1;
       while (row < n && col >= 0) { // start top - right traversal
        if (mat[row][col] == 1) {  // if 1 found, update row index having max ones
          maxOneRowIdx = row; 
          col--; // check if left col also has 1
        }
        else { // if 1 not found, move to next row
          row++; 
        }
       }
       return maxOneRowIdx;

    }
}

// T.C => O(n + m)
// S.C => O(1)
