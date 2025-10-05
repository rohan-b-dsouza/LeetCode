// Optimal

class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length; 
        int xor = 0;
        // Set a flag to track the edge case where all elements are 0, as in that case xor will be 0 but answer will not be n - 1, it will be 0
        boolean allZero = true;
        // For each element
        for (int num : nums) {
            // If element is non - zero set allZero Flag to false
            if (num != 0) allZero = false;
            // Now, xor the element with 'xor'
            xor ^= num;
        }
        // If allZero flag is still true, return 0 as all elements in the array are zero
        if (allZero) return 0;
        // Else, if xor of all elements is zero, we can exclude one element which is making the 'xor' 0 and hence return n - 1,
        // If xor of all elements in nums is non - zero, return n
        return (xor == 0) ? n - 1 : n;
    }
}

// T.C => O(n)
// S.C => O(1)
