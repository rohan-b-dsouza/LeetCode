// Better 

class Solution {

    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return true;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][matrix[i].length - 1]) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }
}

// T.C => O(n + log(m)) -----------------{ Binary search is applied only once for a particular row, resulting in a time complexity of O(n + logm) instead of O(n*logm) }
// S.C => O(1)
