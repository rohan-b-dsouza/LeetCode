// Brute

// (Using the fact that max element will definitely be a peak element too as no adjacent elements are equal (mentioned in problem))

class Solution {
    public int[] findPeakGrid(int[][] mat) {
      int n = mat.length;
      int m = mat[0].length;
      int max = Integer.MIN_VALUE;
      int resultIdx[] = new int[2]; 
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (mat[i][j] > max) {
                max = mat[i][j];
                resultIdx[0] = i;
                resultIdx[1] = j;
            }
        }
      }
      return resultIdx;
    }
}

// T.C => O(n * m)
// S.C => O(1) 
