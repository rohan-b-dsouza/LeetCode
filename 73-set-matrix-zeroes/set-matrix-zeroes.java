class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1;
        // marking the cols and rows where zero occurs
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) {
                         matrix[0][j] = 0;
                    }
                    else {
                        col0 = 0;
                    }
                }
            }
        }
        // marking the non-flag matrix part zero by checking with the flag matrix part
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        // marking the flag matrix row zero by checking with first cell
        if (matrix[0][0] == 0) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        // marking the flag matrix col zero by checking with col0
        if (col0 == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            } 
        }
    }
}