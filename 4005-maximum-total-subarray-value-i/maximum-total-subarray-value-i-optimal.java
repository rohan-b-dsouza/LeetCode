// Optimal

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        // Determine max and min elements of the array
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }
        // Since it is allowed to choose the same subarray multiple times and we need the maximum possible total value, therefore we need to take the entire subarray k times as this will give us the max total value
        return ((long) max - min) * k;
    }
}

// T.C => O(n)
// S.C => O(1)
