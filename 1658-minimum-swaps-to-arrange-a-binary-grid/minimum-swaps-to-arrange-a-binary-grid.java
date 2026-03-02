class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int swaps = 0;
        int[] trailingZeroes = new int[n];
        for (int i = 0; i < n; i++) {
            int zeroes = 0;
            int j = n - 1;
            while (j >= 0 && grid[i][j] == 0) {
                zeroes++;
                j--;
            }
            trailingZeroes[i] = zeroes;
        }
        for (int i = 0; i < n; i++) {
            int reqd = n - i - 1;
            if (trailingZeroes[i] >= reqd) continue; 
            int j = i + 1;
            while (j < n && trailingZeroes[j] < reqd) j++;
            if (j == n) return -1;
            while (j > i) {
                int temp = trailingZeroes[j];
                trailingZeroes[j] = trailingZeroes[j - 1];
                trailingZeroes[j - 1] = temp;
                j--;
                swaps++;
            }
        }
        return swaps;
    }
}