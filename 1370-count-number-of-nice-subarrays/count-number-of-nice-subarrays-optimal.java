// Optimal (Sliding Window) (Slight variation of 930. Binary Subarrays With Sum)

class Solution {
    // Function to count the no. of nice subarrays
    public int countSubarrays(int[] nums, int k) {
        // If k is negative return 0
        if (k < 0) return 0;
        int n = nums.length;
        // Assign two pointers 'l' and 'r'
        int l = 0;
        int r = 0;
        int sum = 0; // Initialize sum of odd numbers 'sum' to zero
        int cnt = 0; // Initialize no. of nice subarrays to zero
        // Traverse till r is within bounds
        while (r < n) {
            // Add current element's parity (1 for even, 0 for odd) to the sum to track the no. of odd nos. in current window
            sum += nums[r] % 2;
            // If no. of odd numbers exceed k, shrink the window till sum is again within k bounds
            while (sum > k) {
                // Decrement the element's parity at 'l' from sum till sum is not <= k
                sum -= nums[l] % 2;
                // Increment left pointer 'l'
                l++;
            }
            // Compute the no. of nice subarrays for current window
            cnt += r - l + 1;
            // Expand the window using right pointer 'r'
            r++;
        }
        // Return cnt
        return cnt;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        // Compute the no. of nice subarrays using {No. of subarrays with odd nos. <= k} - {No. of subarrays with odd nos. <= k - 1}
        return countSubarrays(nums, k) - countSubarrays(nums, k - 1);
    }
}
