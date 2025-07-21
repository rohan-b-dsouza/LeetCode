// Optimal

class Solution {
    public int getIslandSum (int row, int col, int[][] grid, int n, int m) {
        // Base Condition :- If row,col are out of bounds or cell is visited or cell has zero, return 0
        if (row < 0 || row > n - 1 || col < 0 || col > m - 1 || grid[row][col] == -1 || grid[row][col] == 0) {
            return 0;
        }
        // store the current cell value
        int islandSum = grid[row][col];
        grid[row][col] = -1; // mark current cell as visited
        // Recursive Step :- Recurse in top, bottom, left, right to find valid cells
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
        // traverse over the matrix and call the recursive func only for valid cells
        for (int i = 0; i < n; i++) {
            for (int j  = 0; j < m; j++) {
                // check if cell is valid for forming an island
                if (grid[i][j] != 0 && grid[i][j] != -1) { 
                    int islandSum = getIslandSum(i, j, grid, n, m);  // call the recursive function
                    if (islandSum % k == 0) cnt++; // check if island value is divisible by given k
                }
            }
        }
        return cnt;
    }
}

// T.C => O(n * m) — each cell is visited once at most.
// S.C => O(n * m) for recursive calls (i.e worst case -> when entire grid is one big valid island)
