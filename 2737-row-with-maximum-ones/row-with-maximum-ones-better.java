// Better (Use only when array is already in sorted order) =>

class Solution {
  public int rowWithMax1s(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;
    int resultIdx = -1;
    int cntOne = 0;
    for (int i = 0; i < n; i++) {
      int low = 0;
      int high = m - 1;
      while (low <= high) {
        int mid = low + (high - low) / 2;
        if (mat[i][mid] == 1) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
      if ((m - low) > cntOne) {
        cntOne = m - low;
        resultIdx = i;
      }
    }
    return resultIdx;
  }
}


// T.C => O(n log m)
// S.C => O(1)
