class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] temp = new int[matrix.length][matrix[0].length];
        int a = n - 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][a] = matrix[i][j];
            }
            a--;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }
}