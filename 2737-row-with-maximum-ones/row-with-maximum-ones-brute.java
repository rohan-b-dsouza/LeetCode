// Optimal (As rows are not sorted) (If rows are already in sorted order, use binary search as the better, and top-right traversal for optimal)
// In this question if we ourselves sort anyways it will be like O(n * m log m) so O(n * m) is the optimal one here.


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

// T.C => O(n * m) where n is no of rows and m is no of columns
// S.C => O(1)
