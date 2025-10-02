// Brute

class Solution {
    public long subArrayRanges(int[] nums) {
     int n = nums.length;
     int sum = 0;
      // Generate all subarrays
     for (int i = 0; i < n; i++) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // Keep a running min and max and keep on adding the sum of each subarray
        for (int j = i; j < n; j++) {
            min = Math.min(min, nums[j]);
            max = Math.max(max, nums[j]);
            sum += (max - min);
        }
     }
      // Return the sum
     return sum;
    }
}

// T.C => O(n ^ 2)
// S.C => O(1)
