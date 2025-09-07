// Optimal

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            // If at least one element is different, just take the entire array as the subarray:
            // i.e Replace each element with the 'AND' of all elements ; taking subarray as entire array, hence requiring one operation
            if (nums[i] != nums[i + 1]) {
                return 1;
            }
        }
        // If all elements are equal, then no operations are required
        return 0;
    }
}

// T.C => O(n)
// S.C => O(1)
