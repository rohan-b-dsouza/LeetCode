// Optimal 

class Solution {
  public int divisor(int[] nums, int mid, int threshold) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += (int) Math.ceil((double) nums[i] / mid);
      if (sum > threshold) return -1;
    }
    return 1;
  }

  public int smallestDivisor(int[] nums, int threshold) {
    if (nums.length > threshold) return -1;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > max) max = nums[i];
    }
    int low = 1;
    int high = max;
    int result = Integer.MAX_VALUE;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (divisor(nums, mid, threshold) == 1) {
        result = Math.min(result, mid);
        high = mid - 1;
      }
      else {
        low = mid + 1;
      }
    }
    if (result == Integer.MAX_VALUE) return -1;
    return result;
  }
}

// T.C => O(log(max) * n)
// S.C => O(1)
