// Optimal (Inspired from the approach applied in 'Find a Peak Element I')

class Solution {
    public int findMaxElement(int[][] mat, int mid, int n, int m) {
        int max = Integer.MIN_VALUE;
        int maxElemRowIdx = -1;
        for (int i = 0; i < n; i++) {
            if (mat[i][mid] > max) {
                max = mat[i][mid];
                maxElemRowIdx = i;
            }
        }
        return maxElemRowIdx;
    } 
    public int[] findPeakGrid(int[][] mat) {
      int n = mat.length;
      int m = mat[0].length;
      int low = 0;
      int high = m - 1;
      while (low <= high) {
        int mid = low + (high - low) / 2;
        int maxElemRowIdx = findMaxElement(mat, mid, n, m);  
        int left = mid > 0 ? mat[maxElemRowIdx][mid - 1] : -1;
        int right = mid < m - 1 ? mat[maxElemRowIdx][mid + 1] : -1;
        if (mat[maxElemRowIdx][mid] > left && mat[maxElemRowIdx][mid] > right) {
            return new int[] {maxElemRowIdx, mid};
        }
        else if (mat[maxElemRowIdx][mid] < left) {
            high = mid - 1;
        }
        else low = mid + 1;
      }
      return new int[] {-1, -1};
    }
}

// T.C => O(n * log (m))
// S.C => O(1)
