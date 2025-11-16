class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        int smax = Integer.MIN_VALUE;
        // Get the largest 2 elements in the array
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            min = Math.min(min, num);
            if (num > max) {
                smax = max;
                max = num;
            }
            else if (num > smax) {
                smax = num;
            }
        }
        return ((max + smax) - min);
    }
}