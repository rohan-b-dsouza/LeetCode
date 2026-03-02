class Solution {
    public int searchSwappableRow(int n, int[][] grid, int k, int trailingZeroes) {
        for (int i = k; i < n; i++) {
            int zeroes = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1 || zeroes == trailingZeroes) break;
                zeroes++;
            }
            if (zeroes == trailingZeroes) {
                return i;
            }
        }
        return -1;
    }
    public void rowSwapHelper(int n, int[][] grid, int k, int swapRow) {
        for (int i = swapRow; i > k; i--) {
            for (int j = 0; j < n; j++) {
                int temp = grid[i][j];
                grid[i][j] = grid[i - 1][j];
                grid[i - 1][j] = temp;
            }
        }
    }
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (grid[i][j] != 0) {
                    int swapRow = searchSwappableRow(n, grid, i + 1, n - i - 1);
                    if (swapRow == -1) return -1;
                    rowSwapHelper(n, grid, i, swapRow);
                    ans += swapRow - i;
                    break;
                }
            }
        }
        return ans;
    }
}