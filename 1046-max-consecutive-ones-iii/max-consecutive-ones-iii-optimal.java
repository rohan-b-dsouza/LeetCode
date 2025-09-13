// Optimal (Sliding Window)

class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        // Initialize maxlen and zeroes to 0
        int maxlen = 0;
        int zeroes = 0;
        // Initialize two pointers l and r to 0
        int l = 0;
        int r = 0;
        // Traverse till r is within bounds 
        while (r < n) {
            // If current element is a 0, increment zeroes
            if (nums[r] == 0) zeroes++;
            // If zeroes exceed k, shrink the window by 1 using 'l' to limit the window to maxlen discovered so far and try to find a larger possible substring in next iteration
            if (zeroes > k) {
                // If a zero is found decrement zeroes
                if (nums[l] == 0) zeroes--;
                l++;
            }
            // Update maxlen
            maxlen = Math.max(maxlen, r - l + 1);
            // Expand the window using 'r' pointer
            r++;
        } 
        // Return maxlen
        return maxlen;
    }
}

// T.C => O(n)
// S.C => O(1)
