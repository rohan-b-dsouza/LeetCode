class Solution {
    public int getIslandSum (int row, int col, int[][] grid, int n, int m) {
        // Base Condition :- If row,col are out of bounds or cell is visited or cell has zero, return 0
        if (row < 0 || row > n - 1 || col < 0 || col > m - 1 || grid[row][col] == -1 || grid[row][col] == 0) {
            return 0;
        }
        int islandSum = grid[row][col];
        grid[row][col] = -1;
        islandSum += getIslandSum(row - 1, col, grid, n, m);
        islandSum += getIslandSum(row + 1, col, grid, n, m);
        islandSum += getIslandSum(row, col - 1, grid, n, m);
        islandSum += getIslandSum(row, col + 1, grid, n, m);
        return islandSum;
    }
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j  = 0; j < m; j++) {
                if (grid[i][j] != 0 && grid[i][j] != -1) {
                    int islandSum = getIslandSum(i, j, grid, n, m);
                    if (islandSum % k == 0) cnt++; 
                }
            }
        }
        return cnt;
    }
}