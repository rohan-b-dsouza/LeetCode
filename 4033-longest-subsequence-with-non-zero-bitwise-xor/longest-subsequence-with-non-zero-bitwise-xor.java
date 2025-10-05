class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length; 
        int xor = 0;
        boolean allZero = true;
        for (int num : nums) {
            if (num != 0) allZero = false;
            xor ^= num;
        }
        if (allZero) return 0;
        return (xor == 0) ? n - 1 : n;
    }
}