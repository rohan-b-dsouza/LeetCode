// Optimal (Sliding Window)

class Solution {
    // Function to count the subarrays <= goal
    public int countSubarrays(int[] nums, int goal) {
        int n = nums.length;
        // If goal is < 0 then return 0 
        if (goal < 0) return 0;
        // Assign left pointer to 0
        int l = 0;
        // Assign right pointer to 0
        int r = 0;
        // Assign a counter to count the no. of subarrays <= goal
        int cnt = 0;
        // Assign a variable sum to compute running sum
        int sum = 0;
        // Traverse till r is within bounds
        while (r < n) {
            // Add current element to sum
            sum += nums[r];
            // If sum is > goal, then shrink the window till sum is again <= goal
            while (sum > goal) {
                // Decrement element at 'l' from sum
                sum -= nums[l];
                // Increment 'l' pointer
                l++;
            }
            // Count the no. of subarrays <= goal within current window
            cnt += r - l + 1;
            // Expand the window using 'r' pointer
            r++;
        }
        // Return the cnt
        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        // Return the (count of subarrays <= goal) - (count of subarrays <= goal - 1)
        return countSubarrays(nums, goal) - countSubarrays(nums, goal - 1);
    }
}

// T.C => O(2 * n) = O(n)
// S.C => O(1)
