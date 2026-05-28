class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;
        char[][] ans = new char[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '.') {
                    int k = j - 1;
                    while (k >= 0 && (boxGrid[i][k] != '*' && boxGrid[i][k] != '#')) {
                        k--;
                    }
                    if (k != -1 && boxGrid[i][k] == '#') {
                        char temp = boxGrid[i][k];
                        boxGrid[i][k] = boxGrid[i][j];
                        boxGrid[i][j] = temp;                  
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[j][n - i - 1] = boxGrid[i][j];
            }
        }
        return ans;
    }
}