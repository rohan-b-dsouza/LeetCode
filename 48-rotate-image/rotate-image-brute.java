class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] temp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][n - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
}

// T.C => O(n*m) + O(n*m) = O(2(n*m)) = O(n*m)
// S.C => O(n*m)
