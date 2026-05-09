class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n][n];
        for (int i = n - 1; i > 0; i--) {
            int j = 0;
            int k = i;
            List<Integer> list = new ArrayList<>();
            while (j < n && k < n) {
                list.add(grid[j++][k++]);
            }
            list.sort(null);
            j = 0; k = i;
            while (j < n && k < n) {
                ans[j][k] = list.get(j);
                j++; k++;
            }
        }
        for (int i = 0; i < n; i++) {
            int j = i;
            int k = 0;
            List<Integer> list = new ArrayList<>();
            while (j < n && k < n) {
                list.add(grid[j++][k++]);
            }
            list.sort((a, b) -> b - a);
            j = i; k = 0;
            while (j < n && k < n) {
                ans[j][k] = list.get(k);
                j++; k++;
            }
        }
        return ans;
    }
}