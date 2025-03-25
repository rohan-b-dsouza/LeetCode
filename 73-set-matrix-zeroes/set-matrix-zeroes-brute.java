// Brute-Force Solution => (Works for Binary as well as Integer Matrix)

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] tempMatrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tempMatrix[i][j] = matrix[i][j]; 
            }
        }
        for (int i = 0; i < m; i++) { 
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < n; k++) {
                        tempMatrix[i][k] = 0; 
                    }
                    for (int k = 0; k < m; k++) {
                        tempMatrix[k][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = tempMatrix[i][j];
            }
        }
    }
}

// T.C => O(n*m) + O(n*m) * O(n + m) + O(n*m) => O(n^3)
// S.C => O(m * n)
