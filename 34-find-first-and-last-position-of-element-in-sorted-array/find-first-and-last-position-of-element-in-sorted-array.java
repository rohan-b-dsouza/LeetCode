// Optimal 1 (Using Bounds)

class Solution {

  static int lowerBound(int[] arr, int target) {
    int ans = -1;
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] >= target) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return ans;
  }

  static int upperBound(int[] arr, int target) {

    int ans = arr.length;
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;

      if (arr[mid] > target) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
      
    }return ans;
  }

  public int[] searchRange(int[] nums, int target) {
    int start = lowerBound(nums, target);
    int end = upperBound(nums, target) - 1;

    if ((start == -1) || (nums[start] != target)) {
      return new int[] {-1, -1};
    }
    return new int[] {start, end};
  }
}

// T.C => O(2 * logn)
// S.C => O(1)