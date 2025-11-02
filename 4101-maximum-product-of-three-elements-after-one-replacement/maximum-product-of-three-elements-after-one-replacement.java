class Solution {
    public long maxProduct(int[] nums) {
        int n = nums.length;
        long max = Math.abs(nums[0]);
        long smax = -1;
        for (int i = 1; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num >= max) {
                smax = max;
                max = num;
            }
            else if (num > smax && num != max) {
                smax = num;
            }
        }
        long prod = max * smax * 100000;
        return prod;
    }
}