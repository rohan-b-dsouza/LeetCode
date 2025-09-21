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
        // Initialize sum to zero
        long sum = 0;
        // Since it is allowed to choose the same subarray multiple times and we need the maximum possible total value, therefore we need to take the entire subarray every time as this will give us the max total value
        for (int i = 0; i < k; i++) {
            sum += ((long)max - min);
        }
        // Return the sum
        return sum;
    }
}