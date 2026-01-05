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