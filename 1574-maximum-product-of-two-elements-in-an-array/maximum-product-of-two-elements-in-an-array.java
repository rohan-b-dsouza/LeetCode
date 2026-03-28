class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                smax = max;
                max = nums[i];
            }
            else if (nums[i] > smax) {
                smax = nums[i];
            }
        }
        return (max - 1) * (smax - 1);
    }
}