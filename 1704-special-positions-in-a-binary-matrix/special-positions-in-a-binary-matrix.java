class Solution {
    public boolean isSpecial(int[][] mat, int r, int c, int n, int m) {
        for (int i = 0; i < m; i++) {
            if (i != c && mat[r][i] == 1) return false;
        }
        for (int i = 0; i < n; i++) {
            if (i != r && mat[i][c] == 1) return false;
        }
        return true;
    }
    public int numSpecial(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    boolean check = isSpecial(mat, i, j, n, m);   
                    if (check) ans++;    
                }
            }
        }
    return ans;
    }
}