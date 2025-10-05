// Optimal

class Solution {
    public int alternatingSum(int[] nums) {
        int sum = 0;
        int sign = 1;
        int n = nums.length;
        // Since modulo operation is slightly inefficient, we use a variable sign to help us do that task
        // Initially sign is positive 1 hence multiplying with nums[i] adds it to sum, and then sign is flipped to ensure next time nums[i] is subtracted from sum
        // This repeats till i reaches out of bounds
        for (int i = 0; i < n; i++) {
            sum += sign * nums[i];
            sign = -sign;
        }
        return sum;
    }
}

// T.C => O(n)
// S.C => O(1)
