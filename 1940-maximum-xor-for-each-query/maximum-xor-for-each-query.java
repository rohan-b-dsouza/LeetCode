class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int ans[] = new int[n];
        int maxi = (1 << maximumBit) - 1;
        System.out.println(maxi);
        for (int i = 1; i < n; i++) {
            nums[i] ^= nums[i - 1];
        }
        int idx = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans[idx++] = (nums[i] ^ maxi);
        }
        return ans;

    }
}