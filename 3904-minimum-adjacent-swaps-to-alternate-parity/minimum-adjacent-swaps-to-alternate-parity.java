class Solution {
    public int noOfSwaps(int[] nums, int Parity) {
        int pos = 0;
        int swaps = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == Parity) {
                swaps += Math.abs(i - pos);
                pos += 2;
            }
        }
        return swaps;
    } 
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int even = 0, odd = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) even ++;
            else odd ++;
        }
        if (Math.abs(even - odd) > 1) return -1;

        int ans = Integer.MAX_VALUE;
        if (even >= odd) ans = Math.min(ans, noOfSwaps(nums, 0));
        if (odd >= even) ans = Math.min(ans, noOfSwaps(nums, 1));
        return ans;
    }
}