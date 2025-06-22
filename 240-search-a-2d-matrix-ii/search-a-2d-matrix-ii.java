class Solution {
    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
      int n = matrix.length; int m = matrix[0].length;
      for (int i = 0; i < n; i++) {
        if (target >= matrix[i][0] && target <= matrix[i][m - 1]) {
            boolean result = binarySearch(matrix[i], target);
            if (result) return result;
        }
      }
      return false;
    }
}