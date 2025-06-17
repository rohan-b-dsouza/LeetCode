// Brute


class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int resultIdx = 0;
        int maxCnt = 0;
        for (int i = 0; i < mat.length; i++) {
            int cntOne = 0;
            for (int j = 0; j < mat[0].length; j++) {
                cntOne+=mat[i][j];
            }
            if (cntOne > maxCnt) {
                maxCnt = cntOne;
                resultIdx = i;
            }
            cntOne = 0;
        }
        return new int[] {resultIdx, maxCnt};
    }
}

// T.C => O(m * n) where m is no of rows and m is no of columns
// S.C => O(1)
