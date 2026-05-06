class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        xor ^= k;
        int ans = 0;
        while (xor != 0) {
            ans += (xor & 1);
            xor >>= 1;
        }
        return ans;
    }
}