// Optimal 

class Solution {
  public int singleNonDuplicate(int[] nums) {
    int n = nums.length;
    int low = 1;
    int high = n - 2;
    // Edge cases:
    if (n == 1) return nums[0];
    if (nums[0] != nums[1]) return nums[0];
    if (nums[n - 1] != nums[n - 2]) return nums[n - 1];
    while (low <= high) {
      int mid = low + (high - low) / 2;
      // If nums[mid] is the single element:
      if ((nums[mid] != nums[mid - 1]) && (nums[mid] != nums[mid + 1])) return nums[mid];
      // We are in the left part:
      if ((mid % 2 == 0) && (nums[mid] == nums[mid + 1])
          || ((mid % 2 != 0) && nums[mid] == nums[mid - 1])) {
        // Eliminate the left half:
        low = mid + 1;
      }
      // We are in the right part:
      else {
        // Eliminate the right half:
        high = mid - 1;
      }
    }
    return -1;
  }
}

// T.C => O(log(n))
// S.C => O(1)
