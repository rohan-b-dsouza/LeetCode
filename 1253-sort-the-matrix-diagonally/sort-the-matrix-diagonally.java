class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < m; i++) {
            int j = 0;
            int k = i;
            List<Integer> temp = new ArrayList<>();
            while (j < n && k < m) {
                temp.add(mat[j++][k++]);
            }
            temp.sort(null);
            j = 0; k = i;
            while (j < n && k < m) {
                mat[j][k] = temp.get(j);
                j++; k++;
            }
        }
        for (int i = 1; i < n; i++) {
            int j = i;
            int k = 0;
            List<Integer> temp = new ArrayList<>();
            while (j < n && k < m) {
                temp.add(mat[j++][k++]);
            }
            temp.sort(null);
            j = i; k = 0;
            while (j < n && k < m) {
                mat[j][k] = temp.get(k);
                j++; k++;
            }
        }
        return mat;
    }
}