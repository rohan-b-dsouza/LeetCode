// Brute

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }
}

// T.C => O(n * m) where n is no of rows and m is no of columns
// S.C => O(1)
