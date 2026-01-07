// Optimal

// Logic:- If number of negative elements are even, then its always fixable. Hence, ans will be sum of all abs values of the matrix. If number of negative
// elements are odd, then one element will not be fixable. Since we want max sum, we will keep the smallest element as negative, therefore ans will be total sum - 2 * min.
// The reason we subtract 2 * min is because initially we took sum of all elements of the matrix.

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += Math.abs(matrix[i][j]);
                min = Math.min(Math.abs(matrix[i][j]), min);
                if (matrix[i][j] < 0) cnt++;
            }
        }
        return cnt % 2 == 0 ? sum : sum - 2 * min;
    }
}

// T.C => O(n * m)
// S.C => O(1)
