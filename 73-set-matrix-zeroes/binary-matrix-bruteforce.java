// Note:- This is the bruteforce solution in the case where the matrix is a binary matrix(i.e consists of only zeroes or ones) which is not the case in leetcode's qn.

class Solution {
    public void markRow(int[][] matrix, int i) {
        for (int k = 0; k < matrix[i].length; k++) {
            if (matrix[i][k] != 0) {
                matrix[i][k] = -1;
            }
        }

    }

    public void markCol(int[][] matrix, int j) {
        for (int k = 0; k < matrix.length; k++) {
            if (matrix[k][j] != 0) {
                matrix[k][j] = -1;
            }
        }

    }

    public void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    markRow(matrix, i);
                    markCol(matrix, j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1) matrix[i][j] = 0;
            }
        }
    }
}
