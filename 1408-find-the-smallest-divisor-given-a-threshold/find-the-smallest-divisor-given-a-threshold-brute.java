// Brute

class Solution {
  public int smallestDivisor(int[] nums, int threshold) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] > max) {
            max = nums[i];
        }
    }
    for (int i = 1; i <= max; i++) {
        int sum = 0;
        for (int j = 0; j < nums.length;j++) {
            sum += (int) Math.ceil((double) nums[j] / i);
            if (sum > threshold) break;
        }
        if (sum <= threshold) return i;
    }
    return -1;
  }
}

// T.C => O(max * n) ----where n is the size of the array and max is maximum element in array
// S.C => O(1)
