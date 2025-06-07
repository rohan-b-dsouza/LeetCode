// Optimal 2 (Using Binarysearch)

class Solution {
  public int getStart(int[] nums, int target) {
    int low = 0;
    int start = -1;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        start = mid;
        high = mid - 1;
      }
      else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return start;
  }

  public int getEnd(int[] nums, int target) {
    int low = 0;
    int end = -1;
    int high = nums.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == target) {
        end = mid;
        low = mid + 1;
      }
      else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return end;
  }

  public int[] searchRange(int[] nums, int target) {
    int first = getStart(nums,target);
    if (first == -1) return new int[] {-1,-1};
    int last = getEnd(nums, target);
    return new int[] {first, last};
  }
}


// T.C => O(2 * logn)
// S.C => O(1)